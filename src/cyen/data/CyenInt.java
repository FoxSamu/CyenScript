package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.data.number.INumberData;
import cyen.data.number.data.DataInt;

public class CyenInt extends CyenNumber {

    public final DataInt data;

    public CyenInt( ExecContext ctx, int value ) {
        super( ctx );
        data = new DataInt( value );
    }

    public CyenInt( ExecContext ctx, DataInt value ) {
        super( ctx );
        data = value;
    }

    @Override
    public INumberData data( ExecContext ctx ) {
        return data;
    }

    public Class getParamClass() {
        return int.class;
    }
}
