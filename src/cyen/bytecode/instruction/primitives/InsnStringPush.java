package cyen.bytecode.instruction.primitives;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;
import cyen.data.CyenString;

public class InsnStringPush implements IBytecodeInsn {
    private final String string;

    public InsnStringPush( String string ) {
        this.string = string;
    }

    @Override
    public void execute( ExecContext ctx ) {
        ctx.push( new CyenString( ctx, string ) );
    }
}
