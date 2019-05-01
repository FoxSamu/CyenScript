package cyen.bytecode.instruction.globals;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;
import cyen.data.DataUtil;
import cyen.data.ICyenData;

public class InsnGetGlobalDyn implements IBytecodeInsn {
    @Override
    public void execute( ExecContext ctx ) {
        ICyenData data = ctx.pop();
        ctx.push( ctx.getGlobal( DataUtil.stringify( ctx, data ) ) );
    }
}
