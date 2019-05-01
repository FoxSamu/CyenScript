package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.data.number.INumberData;
import cyen.data.number.data.DataShort;

public class CyenShort extends CyenNumber {

    public final DataShort data;

    public CyenShort( ExecContext ctx, int value ) {
        super( ctx );
        data = new DataShort( value );
    }

    public CyenShort( ExecContext ctx, short value ) {
        super( ctx );
        data = new DataShort( value );
    }

    public CyenShort( ExecContext ctx, DataShort value ) {
        super( ctx );
        data = value;
    }

    @Override
    public INumberData data( ExecContext ctx ) {
        return data;
    }

    public Class getParamClass() {
        return short.class;
    }
}
