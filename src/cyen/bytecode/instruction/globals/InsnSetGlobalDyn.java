package cyen.bytecode.instruction.globals;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;
import cyen.data.DataUtil;
import cyen.data.ICyenData;

public class InsnSetGlobalDyn implements IBytecodeInsn {
    @Override
    public void execute( ExecContext ctx ) {
        ICyenData name = ctx.pop();
        ICyenData data = ctx.pop();
        ctx.setGlobal( DataUtil.stringify( ctx, name ), data );
    }
}
