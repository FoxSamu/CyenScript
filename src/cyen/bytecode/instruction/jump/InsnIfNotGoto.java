package cyen.bytecode.instruction.jump;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;
import cyen.data.ICyenData;

public class InsnIfNotGoto implements IBytecodeInsn {
    private final int n;

    public InsnIfNotGoto( int n ) {
        this.n = n;
    }

    @Override
    public void execute( ExecContext ctx ) {
        ICyenData data = ctx.pop();
        if( ! data.booleanize( ctx ) ) {
            ctx.goTo( n );
        }
    }
}
