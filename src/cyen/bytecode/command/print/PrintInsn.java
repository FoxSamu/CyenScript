package cyen.bytecode.command.print;

import cyen.bytecode.ExecContext;
import cyen.bytecode.command.IBytecodeInsn;
import cyen.data.ICyenData;

public class PrintInsn implements IBytecodeInsn {
    @Override
    public void execute( ExecContext ctx ) {
        ICyenData data = ctx.pop();
        System.out.println( data.stringify( ctx ) );
    }
}
