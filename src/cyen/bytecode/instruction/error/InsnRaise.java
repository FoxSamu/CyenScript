package cyen.bytecode.instruction.error;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;
import cyen.data.ICyenData;
import cyen.data.error.CyenError;

public class InsnRaise implements IBytecodeInsn {
    @Override
    public void execute( ExecContext ctx ) {
        ICyenData data = ctx.pop();
        if( ! ( data instanceof CyenError ) ) {
            data = new CyenError( ctx, data == null ? "null" : data.stringify( ctx ) );
        }
        ctx.raise( (CyenError) data );
    }
}
