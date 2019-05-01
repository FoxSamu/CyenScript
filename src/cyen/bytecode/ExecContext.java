package cyen.bytecode;

import cyen.bytecode.command.IBytecodeInsn;
import cyen.bytecode.util.StackTrace;
import cyen.bytecode.util.TryClosure;
import cyen.data.ICyenData;
import cyen.exception.CyenInvocationException;
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

    public void raise( ICyenData error, StackTrace trace ) throws CyenRaisedException {
        if( tryClosureStack.empty() ) {
            if( isRoot() ) {
                exit();
                throw new CyenRaisedException( error, trace );
            } else {
                parent.raise( error, trace );
            }
        } else {
            TryClosure closure = tryClosureStack.pop();
            goTo( closure.catchLoc );
        }
    }

    public void raise( ICyenData error ) throws CyenRaisedException {
        raise( error, getStackTrace() );
    }


    /* LOCALS */

    private void checkLocal( int index ) {
        if( index < 0 ) throw new CyenInvocationException( "Local variable index may not be less than zero!" );
        if( index >= locals.length ) throw new CyenInvocationException( "Local variable table overflow!" );
        if( index >= allocatedLocals ) throw new CyenInvocationException( "Local variable not allocated jet!" );
    }

    public void setLocal( int index, ICyenData value ) {
        checkLocal( index );
        locals[ index ] = value;
    }

    public ICyenData getLocal( int index ) {
        checkLocal( index );
        return locals[ index ];
    }

    public void allocLocals( int amount ) {
        if( amount < 0 ) {
            throw new CyenInvocationException( "Tried to allocate a negative amount of locals!" );
        }
        if( allocatedLocals + amount > locals.length ) {
            throw new CyenInvocationException( "Tried to allocate more locals than available!" );
        }
        allocatedLocals += amount;
    }

    public void freeLocals( int amount ) {
        if( amount < 0 ) {
            throw new CyenInvocationException( "Tried to free a negative amount of locals!" );
        }
        if( allocatedLocals - amount < 0 ) {
            throw new CyenInvocationException( "Tried to free more locals than allocated" );
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
        if( stack.empty() ) throw new CyenInvocationException( "Tried popping from empty stack!" );
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
}
