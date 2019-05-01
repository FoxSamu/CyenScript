package cyen.data;

import cyen.bytecode.ExecContext;

public class CyenBoolean extends CyenObject {

    private final boolean value;

    public CyenBoolean( ExecContext ctx, boolean value ) {
        super( ctx );
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String stringify( ExecContext ctx ) {
        return value ? "true" : "false";
    }

    @Override
    public String type() {
        return "bool";
    }

    @Override
    public Class getParamClass() {
        return boolean.class;
    }
}
