package cyen.bytecode.instruction.push;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IInstruction;
import cyen.data.CyenString;

public class InsnStringPush implements IInstruction {
    private final String string;

    public InsnStringPush( String string ) {
        this.string = string;
    }

    @Override
    public void execute( ExecContext ctx ) {
        ctx.push( new CyenString( ctx, string ) );
    }
}
