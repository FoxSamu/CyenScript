package cyen.bytecode.command.jump;

import cyen.bytecode.ExecContext;
import cyen.bytecode.command.IBytecodeInsn;

public class GotoInsn implements IBytecodeInsn {
    private final int n;

    public GotoInsn( int n ) {
        this.n = n;
    }

    @Override
    public void execute( ExecContext ctx ) {
        ctx.goTo( n );
    }
}
