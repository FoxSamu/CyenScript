package cyen.bytecode;

import cyen.bytecode.instruction.IInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bytecode {
    private final ArrayList<IInstruction> instructions = new ArrayList<>();

    public Bytecode() {

    }

    public Bytecode( IInstruction... insns ) {
        instructions.addAll( Arrays.asList( insns ) );
    }

    public Bytecode( List<? extends IInstruction> insns ) {
        instructions.addAll( insns );
    }

    public Bytecode( Bytecode insns ) {
        instructions.addAll( insns.instructions );
    }

    public IInstruction getInsn( int index ) {
        return instructions.get( index );
    }

    public void insertInsn( int index, IInstruction insn ) {
        instructions.add( index, insn );
    }

    public void setInsn( int index, IInstruction insn ) {
        instructions.set( index, insn );
    }

    public void appendInsn( IInstruction insn ) {
        instructions.add( insn );
    }

    public void prependInsn( IInstruction insn ) {
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

    public IInstruction removeInsn( int index ) {
        return instructions.remove( index );
    }

    public void removeInsn( IInstruction insn ) {
        instructions.remove( insn );
    }

    public int insnCount() {
        return instructions.size();
    }
}
