package cyen.data.number.data;

import cyen.data.number.ENumberType;
import cyen.data.number.INumberData;

public class DataFloat implements INumberData {
    public final float value;

    public DataFloat( float value ) {
        this.value = value;
    }

    public DataFloat( INumberData data ) {
        this( data.floatValue() );
    }

    public DataFloat() {
        this( 0 );
    }

    @Override
    public double doubleValue() {
        return (double) value;
    }

    @Override
    public float floatValue() {
        return value;
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
        return (long) value;
    }

    @Override
    public String stringified() {
        return "" + value;
    }

    @Override
    public ENumberType type() {
        return ENumberType.FLOAT;
    }

    @Override
    public String toString() {
        return stringified() + "F";
    }
}
