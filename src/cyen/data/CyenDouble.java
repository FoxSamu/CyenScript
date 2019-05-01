package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.data.number.INumberData;
import cyen.data.number.data.DataDouble;

public class CyenDouble extends CyenNumber {

    public final DataDouble data;

    public CyenDouble( ExecContext ctx, double value ) {
        super( ctx );
        data = new DataDouble( value );
    }

    public CyenDouble( ExecContext ctx, DataDouble value ) {
        super( ctx );
        data = value;
    }

    @Override
    public INumberData data( ExecContext ctx ) {
        return data;
    }

    public Class getParamClass() {
        return double.class;
    }
}
