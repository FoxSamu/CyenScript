package cyen.bytecode;

import cyen.bytecode.instruction.IBytecodeInsn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bytecode {
    private final ArrayList<IBytecodeInsn> instructions = new ArrayList<>();

    public Bytecode() {

    }

    public Bytecode( IBytecodeInsn... insns ) {
        instructions.addAll( Arrays.asList( insns ) );
    }

    public Bytecode( List<? extends IBytecodeInsn> insns ) {
        instructions.addAll( insns );
    }

    public Bytecode( Bytecode insns ) {
        instructions.addAll( insns.instructions );
    }

    public IBytecodeInsn getInsn( int index ) {
        return instructions.get( index );
    }

    public void insertInsn( int index, IBytecodeInsn insn ) {
        instructions.add( index, insn );
    }

    public void setInsn( int index, IBytecodeInsn insn ) {
        instructions.set( index, insn );
    }

    public void appendInsn( IBytecodeInsn insn ) {
        instructions.add( insn );
    }

    public void prependInsn( IBytecodeInsn insn ) {
        instructions.add( 0, insn );
    }

    public void insertBytecode( int index, Bytecode bytecode ) {
        instructions.addAll( index, bytecode.instructions );
    }

    public void appendBytecode( Bytecode bytecode ) {
        instructions.addAll( bytecode.instructions );
    }

    public void prependBytecode( Bytecode bytecode ) {
        instructions.addAll( 0, bytecode.instructions );
    }

    public IBytecodeInsn removeInsn( int index ) {
        return instructions.remove( index );
    }

    public void removeInsn( IBytecodeInsn insn ) {
        instructions.remove( insn );
    }

    public int insnCount() {
        return instructions.size();
    }
}
