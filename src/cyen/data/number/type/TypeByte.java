package cyen.data.number.type;

import cyen.data.number.INumberData;
import cyen.data.number.INumberType;
import cyen.data.number.data.DataByte;
import cyen.data.number.data.DataDouble;
import cyen.util.NumberUtils;

public class TypeByte implements INumberType {
    @Override
    public INumberData add( INumberData self, INumberData other ) {
        return new DataByte( self.byteValue() + other.byteValue() );
    }

    @Override
    public INumberData sub( INumberData self, INumberData other ) {
        return new DataByte( self.byteValue() - other.byteValue() );
    }

    @Override
    public INumberData mul( INumberData self, INumberData other ) {
        return new DataByte( self.byteValue() * other.byteValue() );
    }

    @Override
    public INumberData div( INumberData self, INumberData other ) {
        byte s = self.byteValue(), o = other.byteValue();
        if( s / o * o != s ) return new DataDouble( self.doubleValue() / other.doubleValue() );
        return new DataByte( s / o );
    }

    @Override
    public INumberData floorDiv( INumberData self, INumberData other ) {
        return new DataByte( self.byteValue() / other.byteValue() );
    }

    @Override
    public INumberData mod( INumberData self, INumberData other ) {
        return new DataByte( self.byteValue() % other.byteValue() );
    }

    @Override
    public INumberData pow( INumberData self, INumberData other ) {
        return new DataByte( (int) Math.pow( self.byteValue(), other.byteValue() ) );
    }

    @Override
    public INumberData neg( INumberData self ) {
        return new DataByte( - self.byteValue() );
    }

    @Override
    public INumberData abs( INumberData self ) {
        return new DataByte( Math.abs( self.byteValue() ) );
    }

    @Override
    public INumberData imag( INumberData self ) {
        return new DataByte();
    }

    @Override
    public INumberData real( INumberData self ) {
        return new DataByte( self );
    }

    @Override
    public INumberData floor( INumberData self ) {
        return new DataByte( self.byteValue() );
    }

    @Override
    public INumberData ceil( INumberData self ) {
        return new DataByte( self.byteValue() );
    }

    @Override
    public INumberData round( INumberData self ) {
        return new DataByte( self.byteValue() );
    }

    @Override
    public INumberData leftShift( INumberData self, int amount ) {
        return new DataByte( self.byteValue() << amount );
    }

    @Override
    public INumberData rightShiftSigned( INumberData self, int amount ) {
        return new DataByte( self.byteValue() >> amount );
    }

    @Override
    public INumberData rightShiftUnsigned( INumberData self, int amount ) {
        return new DataByte( self.byteValue() >>> amount );
    }

    @Override
    public INumberData leftRotate( INumberData self, int amount ) {
        return new DataByte( NumberUtils.rotateLeft( self.byteValue(), amount ) );
    }

    @Override
    public INumberData rightRotate( INumberData self, int amount ) {
        return new DataByte( NumberUtils.rotateRight( self.byteValue(), amount ) );
    }

    @Override
    public INumberData bitNot( INumberData self ) {
        return new DataByte( ~ self.byteValue() );
    }

    @Override
    public INumberData bitFlip( INumberData self ) {
        return new DataByte( NumberUtils.reverseBits( self.byteValue() ) );
    }

    @Override
    public INumberData bitCount( INumberData self ) {
        return new DataByte( Integer.bitCount( self.byteValue() & 0xff ) );
    }

    @Override
    public INumberData binarySwap( INumberData self ) {
        return self;
    }

    @Override
    public INumberData bitOr( INumberData self, INumberData other ) {
        return new DataByte( self.byteValue() | other.byteValue() );
    }

    @Override
    public INumberData bitAnd( INumberData self, INumberData other ) {
        return new DataByte( self.byteValue() & other.byteValue() );
    }

    @Override
    public INumberData bitXor( INumberData self, INumberData other ) {
        return new DataByte( self.byteValue() ^ other.byteValue() );
    }

    @Override
    public INumberData inst( byte n ) {
        return new DataByte( n );
    }

    @Override
    public INumberData inst( short n ) {
        return new DataByte( (byte) n );
    }

    @Override
    public INumberData inst( int n ) {
        return new DataByte( (byte) n );
    }

    @Override
    public INumberData inst( long n ) {
        return new DataByte( (byte) n );
    }

    @Override
    public INumberData inst( float n ) {
        return new DataByte( (byte) n );
    }

    @Override
    public INumberData inst( double n ) {
        return new DataByte( (byte) n );
    }

    @Override
    public boolean isFloatingPoint() {
        return false;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String type() {
        return "byte";
    }
}
