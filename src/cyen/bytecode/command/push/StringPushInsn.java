package cyen.bytecode.command.push;

import cyen.bytecode.ExecContext;
import cyen.bytecode.command.IBytecodeInsn;
import cyen.data.CyenString;

public class StringPushInsn implements IBytecodeInsn {
    private final String string;

    public StringPushInsn( String string ) {
        this.string = string;
    }

    @Override
    public void execute( ExecContext ctx ) {
        ctx.push( new CyenString( ctx, string ) );
    }
}
