package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.data.number.INumberData;
import cyen.data.number.data.DataFloat;

public class CyenFloat extends CyenNumber {

    public final DataFloat data;

    public CyenFloat( ExecContext ctx, float value ) {
        super( ctx );
        data = new DataFloat( value );
    }

    public CyenFloat( ExecContext ctx, DataFloat value ) {
        super( ctx );
        data = value;
    }

    @Override
    public INumberData data( ExecContext ctx ) {
        return data;
    }

    public Class getParamClass() {
        return float.class;
    }
}
