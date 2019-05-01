package cyen.util;


import cyen.bytecode.ExecContext;
import cyen.data.ICyenData;

@Deprecated
public class MethodsInvocable implements IInvocable {

    private final Object object;
    private final Class cls;
    private final String name;

    public MethodsInvocable( Object object, Class cls, String name ) {
        this.object = object;
        this.cls = cls;
        this.name = name;
    }



    @Override
    public ICyenData invoke( ExecContext context, ICyenData self, ICyenData... params ) {
        return null;
    }

    @Override
    public String getStringified() {
        return "[native function]";
    }
}
