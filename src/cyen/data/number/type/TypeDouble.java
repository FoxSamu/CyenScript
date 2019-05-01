package cyen.data.number.type;

import cyen.data.number.INumberData;
import cyen.data.number.INumberType;
import cyen.data.number.data.DataDouble;
import cyen.util.NumberUtils;

public class TypeDouble implements INumberType {
    @Override
    public INumberData add( INumberData self, INumberData other ) {
        return new DataDouble( self.doubleValue() + other.doubleValue() );
    }

    @Override
    public INumberData sub( INumberData self, INumberData other ) {
        return new DataDouble( self.doubleValue() - other.doubleValue() );
    }

    @Override
    public INumberData mul( INumberData self, INumberData other ) {
        return new DataDouble( self.doubleValue() * other.doubleValue() );
    }

    @Override
    public INumberData div( INumberData self, INumberData other ) {
        return new DataDouble( self.doubleValue() / other.doubleValue() );
    }

    @Override
    public INumberData floorDiv( INumberData self, INumberData other ) {
        return new DataDouble( NumberUtils.integerRound( self.doubleValue() / other.doubleValue() ) );
    }

    @Override
    public INumberData mod( INumberData self, INumberData other ) {
        return new DataDouble( self.doubleValue() % other.doubleValue() );
    }

    @Override
    public INumberData pow( INumberData self, INumberData other ) {
        return new DataDouble( Math.pow( self.doubleValue(), other.doubleValue() ) );
    }

    @Override
    public INumberData neg( INumberData self ) {
        return new DataDouble( - self.doubleValue() );
    }

    @Override
    public INumberData abs( INumberData self ) {
        return new DataDouble( Math.abs( self.doubleValue() ) );
    }

    @Override
    public INumberData imag( INumberData self ) {
        return new DataDouble();
    }

    @Override
    public INumberData real( INumberData self ) {
        return new DataDouble( self );
    }

    @Override
    public INumberData floor( INumberData self ) {
        return new DataDouble( Math.floor( self.doubleValue() ) );
    }

    @Override
    public INumberData ceil( INumberData self ) {
        return new DataDouble( Math.ceil( self.doubleValue() ) );
    }

    @Override
    public INumberData round( INumberData self ) {
        return new DataDouble( Math.round( self.doubleValue() ) );
    }

    @Override
    public INumberData leftShift( INumberData self, int amount ) {
        return new DataDouble( self.longValue() << amount );
    }

    @Override
    public INumberData rightShiftSigned( INumberData self, int amount ) {
        return new DataDouble( self.longValue() >> amount );
    }

    @Override
    public INumberData rightShiftUnsigned( INumberData self, int amount ) {
        return new DataDouble( self.longValue() >>> amount );
    }

    @Override
    public INumberData leftRotate( INumberData self, int amount ) {
        return new DataDouble( Long.rotateLeft( self.longValue(), amount ) );
    }

    @Override
    public INumberData rightRotate( INumberData self, int amount ) {
        return new DataDouble( Long.rotateRight( self.longValue(), amount ) );
    }

    @Override
    public INumberData bitNot( INumberData self ) {
        return new DataDouble( ~ self.longValue() );
    }

    @Override
    public INumberData bitFlip( INumberData self ) {
        return new DataDouble( Long.reverse( self.longValue() ) );
    }

    @Override
    public INumberData bitCount( INumberData self ) {
        return new DataDouble( Long.bitCount( self.longValue() ) );
    }

    @Override
    public INumberData binarySwap( INumberData self ) {
        return new DataDouble( Double.longBitsToDouble( self.longValue() ) );
    }

    @Override
    public INumberData bitOr( INumberData self, INumberData other ) {
        return new DataDouble( self.longValue() | other.longValue() );
    }

    @Override
    public INumberData bitAnd( INumberData self, INumberData other ) {
        return new DataDouble( self.longValue() & other.longValue() );
    }

    @Override
    public INumberData bitXor( INumberData self, INumberData other ) {
        return new DataDouble( self.longValue() ^ other.longValue() );
    }

    @Override
    public INumberData inst( byte n ) {
        return new DataDouble( n );
    }

    @Override
    public INumberData inst( short n ) {
        return new DataDouble( n );
    }

    @Override
    public INumberData inst( int n ) {
        return new DataDouble( n );
    }

    @Override
    public INumberData inst( long n ) {
        return new DataDouble( n );
    }

    @Override
    public INumberData inst( float n ) {
        return new DataDouble( n );
    }

    @Override
    public INumberData inst( double n ) {
        return new DataDouble( n );
    }

    @Override
    public boolean isFloatingPoint() {
        return false;
    }

    @Override
    public int getLevel() {
        return 5;
    }

    @Override
    public String type() {
        return "double";
    }
}
