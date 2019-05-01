package cyen.data.number.data;

import cyen.data.number.ENumberType;
import cyen.data.number.INumberData;

public class DataByte implements INumberData {
    public final byte value;

    public DataByte( byte value ) {
        this.value = value;
    }

    public DataByte( int value ) {
        this.value = (byte) value;
    }

    public DataByte( INumberData data ) {
        this( data.byteValue() );
    }

    public DataByte() {
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
        return value;
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
        return ENumberType.BYTE;
    }

    @Override
    public String toString() {
        return stringified() + "B";
    }
}
