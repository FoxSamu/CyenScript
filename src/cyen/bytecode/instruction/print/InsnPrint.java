package cyen.bytecode.instruction.print;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IInstruction;
import cyen.data.ICyenData;

public class InsnPrint implements IInstruction {
    @Override
    public void execute( ExecContext ctx ) {
        ICyenData data = ctx.pop();
        System.out.println( data.stringify( ctx ) );
    }
}
