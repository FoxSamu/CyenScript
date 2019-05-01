package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.data.number.INumberData;
import cyen.data.number.data.DataByte;

public class CyenByte extends CyenNumber {

    public final DataByte data;

    public CyenByte( ExecContext ctx, int value ) {
        super( ctx );
        data = new DataByte( value );
    }

    public CyenByte( ExecContext ctx, byte value ) {
        super( ctx );
        data = new DataByte( value );
    }

    public CyenByte( ExecContext ctx, DataByte value ) {
        super( ctx );
        data = value;
    }

    @Override
    public INumberData data( ExecContext ctx ) {
        return data;
    }

    @Override
    public Class getParamClass() {
        return byte.class;
    }
}
