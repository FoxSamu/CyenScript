package cyen.data.number.data;

import cyen.data.number.ENumberType;
import cyen.data.number.INumberData;

public class DataInt implements INumberData {
    public final int value;

    public DataInt( int value ) {
        this.value = value;
    }

    public DataInt( INumberData data ) {
        this( data.intValue() );
    }

    public DataInt() {
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
        return value;
    }

    @Override
    public byte byteValue() {
        return (byte) value;
    }

    @Override
    public short shortValue() {
        return (short) value;
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
        return ENumberType.INT;
    }

    @Override
    public String toString() {
        return stringified();
    }
}
