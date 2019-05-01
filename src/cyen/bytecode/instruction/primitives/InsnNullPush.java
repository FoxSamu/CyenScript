package cyen.bytecode.instruction.primitives;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;

public class InsnNullPush implements IBytecodeInsn {
    @Override
    public void execute( ExecContext ctx ) {
        ctx.push( null );
    }
}
