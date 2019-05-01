package cyen.data.number.data;

import cyen.data.number.ENumberType;
import cyen.data.number.INumberData;

public class DataShort implements INumberData {
    public final short value;

    public DataShort( short value ) {
        this.value = value;
    }

    public DataShort( int value ) {
        this.value = (short) value;
    }

    public DataShort( INumberData data ) {
        this( data.shortValue() );
    }

    public DataShort() {
        this( 0 );
    }

    @Override
    public double doubleValue() {
        return (double) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public byte byteValue() {
        return (byte) value;
    }

    @Override
    public short shortValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public String stringified() {
        return "" + value;
    }

    @Override
    public ENumberType type() {
        return ENumberType.SHORT;
    }

    @Override
    public String toString() {
        return stringified() + "S";
    }
}
