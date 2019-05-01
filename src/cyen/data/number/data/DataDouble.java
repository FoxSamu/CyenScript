package cyen.data.number.data;

import cyen.data.number.ENumberType;
import cyen.data.number.INumberData;

public class DataDouble implements INumberData {
    public final double value;

    public DataDouble( double value ) {
        this.value = value;
    }

    public DataDouble( INumberData data ) {
        this( data.doubleValue() );
    }

    public DataDouble() {
        this( 0 );
    }

    @Override
    public double doubleValue() {
        return value;
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
        return (long) value;
    }

    @Override
    public String stringified() {
        return "" + value;
    }

    @Override
    public ENumberType type() {
        return ENumberType.DOUBLE;
    }

    @Override
    public String toString() {
        return stringified() + "D";
    }
}
