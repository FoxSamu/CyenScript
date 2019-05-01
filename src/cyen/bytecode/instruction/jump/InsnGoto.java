package cyen.bytecode.instruction.jump;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IInstruction;

public class InsnGoto implements IInstruction {
    private final int n;

    public InsnGoto( int n ) {
        this.n = n;
    }

    @Override
    public void execute( ExecContext ctx ) {
        ctx.goTo( n );
    }
}
