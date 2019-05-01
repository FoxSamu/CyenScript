package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.data.number.INumberData;
import cyen.data.number.data.DataLong;

public class CyenLong extends CyenNumber {

    public final DataLong data;

    public CyenLong( ExecContext ctx, long value ) {
        super( ctx );
        data = new DataLong( value );
    }

    public CyenLong( ExecContext ctx, DataLong value ) {
        super( ctx );
        data = value;
    }

    @Override
    public INumberData data( ExecContext ctx ) {
        return data;
    }

    public Class getParamClass() {
        return long.class;
    }
}
