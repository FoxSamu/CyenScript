package cyen.bytecode.instruction.primitives;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;
import cyen.data.CyenObject;

public class InsnObjectPush implements IBytecodeInsn {
    @Override
    public void execute( ExecContext ctx ) {
        ctx.push( new CyenObject( ctx ) );
    }
}
