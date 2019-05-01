package cyen.bytecode;

import cyen.bytecode.instruction.IBytecodeInsn;
import cyen.bytecode.util.StackTrace;
import cyen.bytecode.util.TryClosure;
import cyen.data.ICyenData;
import cyen.data.error.CyenError;
import cyen.data.error.CyenInternalError;
import cyen.exception.CyenRaisedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ExecContext {
    /** The main stack. Memory is put upon this stack when loaded from memory. */
    private final Stack<ICyenData> stack = new Stack<>();

    /** The try closure stack. */
    private final Stack<TryClosure> tryClosureStack = new Stack<>();

    private final HashMap<String, ICyenData> globals = new HashMap<>();

    private ICyenData[] locals = new ICyenData[ 0 ];

    private ICyenData returned;

    private int allocatedLocals;

    private int instructionLoc;

    private int lineNum;

    private int stackSize;

    private ExecContext parent;

    /** The name to display in the stack trace on error */
    private final String name;

    /** The bytecode this context executes */
    private final Bytecode bytecode;

    public ExecContext( String name, Bytecode code ) {
        this.name = name;
        bytecode = code;
    }



    /* Returning */

    public void returnValue( ICyenData value ) {
        instructionLoc = bytecode.insnCount();
        returned = value;
    }

    public ICyenData getReturned() {
        return returned;
    }



    /* PARENTING */

    public void setRoot() {
        setParent( null );
    }

    public ExecContext getParent() {
        return parent;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public void setParent( ExecContext parent ) {
        this.parent = parent;
        if( parent != null ) stackSize = parent.stackSize + 1;
        else stackSize = 0;
    }



    /* ERRORS & STACK */

    public int getStackSize() {
        return stackSize;
    }

    public StackTrace getStackTrace() {
        ArrayList<StackTrace.Element> trace = new ArrayList<>();
        trace.add( new StackTrace.Element( name, lineNum ) );
        ExecContext curr = this;
        while( ! curr.isRoot() ) {
            curr = curr.getParent();
            trace.add( new StackTrace.Element( curr.name, curr.lineNum ) );
        }
        return new StackTrace( trace.toArray( new StackTrace.Element[ 0 ] ) );
    }

    private void raise( CyenError error, StackTrace trace, ExecContext thrower ) throws CyenRaisedException {
        if( ! error.canCatch() || tryClosureStack.empty() ) {
            if( isRoot() ) {
                exit();
                throw new CyenRaisedException( error, trace, thrower );
            } else {
                parent.raise( error, trace, thrower );
            }
        } else {
            TryClosure closure = tryClosureStack.pop();
            goTo( closure.catchLoc );
        }
    }

    public void raise( CyenError error ) throws CyenRaisedException {
        raise( error, getStackTrace(), this );
    }


    /* LOCALS */

    private boolean checkLocal( int index ) {
        if( index < 0 ) { internalError( "Negative local index!" ); return false; }
        if( index >= locals.length ) { internalError( "Local index overflows table size!" ); return false; }
        if( index >= allocatedLocals ) { internalError( "Local index is not yet allocated!" ); return false; }
        return true;
    }

    public void setLocal( int index, ICyenData value ) {
        if( ! checkLocal( index ) ) return;
        locals[ index ] = value;
    }

    public ICyenData getLocal( int index ) {
        if( ! checkLocal( index ) ) return null;
        return locals[ index ];
    }

    public void allocLocals( int amount ) {
        if( amount < 0 ) {
            internalError( "Allocating negative amount of locals!" ); return;
        }
        if( allocatedLocals + amount > locals.length ) {
            internalError( "Allocating more locals than available!" ); return;
        }
        allocatedLocals += amount;
    }

    public void freeLocals( int amount ) {
        if( amount < 0 ) {
            internalError( "Freeing negative amount of locals!" ); return;
        }
        if( allocatedLocals - amount < 0 ) {
            internalError( "Freeing more locals than allocated!" ); return;
        }
        for( int i = 0; i < amount; i++ ) {
            allocatedLocals--;
            locals[ allocatedLocals ] = null;
        }
    }

    public void ensureLocalAmount( int amount ) {
        if( locals.length < amount ) {
            ICyenData[] grown = new ICyenData[ amount ];
            System.arraycopy( locals, 0, grown, 0, locals.length );
            locals = grown;
        }
    }


    public int getAllocatedLocals() {
        return allocatedLocals;
    }



    /* LINE NUMBERS */

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum( int lineNum ) {
        this.lineNum = lineNum;
    }



    /* FLOW */

    public IBytecodeInsn getCurrentInsn() {
        return bytecode.getInsn( instructionLoc );
    }

    public int getCurrentInsnIndex() {
        return instructionLoc;
    }

    public void goTo( int n ) {
        instructionLoc = n;
    }

    public void executeInsn() {
        IBytecodeInsn insn = getCurrentInsn();
        instructionLoc++; // Increase before invoking insn to prevent location increment after jumping
        insn.execute( this );
    }

    public void reset() {
        goTo( 0 );
    }

    public boolean isDone() {
        return instructionLoc >= bytecode.insnCount();
    }

    public void execute() {
        reset();
        while( ! isDone() ) {
            executeInsn();
        }
    }

    public void exit() {
        if( parent != null ) parent.exit();
        instructionLoc = bytecode.insnCount();
    }



    /* DATA STACK */

    public void push( ICyenData data ) {
        stack.push( data );
    }

    public ICyenData pop() {
        if( stack.empty() ) {
            return internalError( "Popping from empty stack" );
        }
        return stack.pop();
    }



    /* GLOBALS */

    public ICyenData getGlobal( String name ) {
        if( ! hasGlobalInternal( name ) && ! isRoot() ) {
            return parent.getGlobal( name );
        }
        return globals.get( name );
    }

    private boolean setGlobalFromChild( String name, ICyenData data ) {
        if( hasGlobalInternal( name ) ) {
            globals.put( name, data );
            return true;
        } else {
            if( ! isRoot() ) {
                return parent.setGlobalFromChild( name, data );
            }
        }
        return false;
    }

    public void setGlobal( String name, ICyenData data ) {
        if( ! setGlobalFromChild( name, data ) ) {
            globals.put( name, data );
        }
    }

    public void removeGlobal( String name ) {
        if( ! hasGlobalInternal( name ) && ! isRoot() ) {
            parent.removeGlobal( name );
            return;
        }
        globals.remove( name );
    }

    private boolean hasGlobalInternal( String name ) {
        return globals.containsKey( name );
    }

    public boolean hasGlobal( String name ) {
        return hasGlobalInternal( name ) || ! isRoot() && parent.hasGlobal( name );
    }


    public ICyenData internalError( String errorMsg ) {
        raise( new CyenInternalError( this, errorMsg ) );
        return null;
    }
}
