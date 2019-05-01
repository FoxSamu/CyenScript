package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.util.IInvocable;

public class CyenFunction extends CyenObject {
    private final IInvocable invocable;

    public CyenFunction( ExecContext ctx, IInvocable invocable ) {
        super( ctx );
        this.invocable = invocable;
    }

    @Override
    public boolean canInvoke( ExecContext ctx ) {
        return true;
    }

    @Override
    public ICyenData invoke( ExecContext ctx, ICyenData self, ICyenData... args ) {
        return invocable.invoke( ctx, self, args );
    }

    @Override
    public String stringify( ExecContext ctx ) {
        return invocable.getStringified();
    }

    @Override
    public Class getParamClass() {
        return CyenFunction.class;
    }
}
