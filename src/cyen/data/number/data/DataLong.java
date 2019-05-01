package cyen.data.number.data;

import cyen.data.number.ENumberType;
import cyen.data.number.INumberData;

public class DataLong implements INumberData {
    public final long value;

    public DataLong( long value ) {
        this.value = value;
    }

    public DataLong( INumberData data ) {
        this( data.longValue() );
    }

    public DataLong() {
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
        return (short) value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public String stringified() {
        return "" + value;
    }

    @Override
    public ENumberType type() {
        return ENumberType.LONG;
    }

    @Override
    public String toString() {
        return stringified() + "L";
    }
}
