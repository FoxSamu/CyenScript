package cyen.data;

import cyen.bytecode.ExecContext;

public class CyenChar extends CyenObject {
    private final char value;

    public CyenChar( ExecContext ctx, char value ) {
        super( ctx );
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String stringify( ExecContext ctx ) {
        return value + "";
    }

    @Override
    public Class getParamClass() {
        return char.class;
    }
}
