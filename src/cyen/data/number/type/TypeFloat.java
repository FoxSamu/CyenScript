package cyen.data.number.type;

import cyen.data.number.INumberData;
import cyen.data.number.INumberType;
import cyen.data.number.data.DataFloat;
import cyen.util.NumberUtils;

public class TypeFloat implements INumberType {
    @Override
    public INumberData add( INumberData self, INumberData other ) {
        return new DataFloat( self.floatValue() + other.floatValue() );
    }

    @Override
    public INumberData sub( INumberData self, INumberData other ) {
        return new DataFloat( self.floatValue() - other.floatValue() );
    }

    @Override
    public INumberData mul( INumberData self, INumberData other ) {
        return new DataFloat( self.floatValue() * other.floatValue() );
    }

    @Override
    public INumberData div( INumberData self, INumberData other ) {
        return new DataFloat( self.floatValue() / other.floatValue() );
    }

    @Override
    public INumberData floorDiv( INumberData self, INumberData other ) {
        return new DataFloat( NumberUtils.integerRound( self.floatValue() / other.floatValue() ) );
    }

    @Override
    public INumberData mod( INumberData self, INumberData other ) {
        return new DataFloat( self.floatValue() % other.floatValue() );
    }

    @Override
    public INumberData pow( INumberData self, INumberData other ) {
        return new DataFloat( (float) Math.pow( self.floatValue(), other.floatValue() ) );
    }

    @Override
    public INumberData neg( INumberData self ) {
        return new DataFloat( - self.floatValue() );
    }

    @Override
    public INumberData abs( INumberData self ) {
        return new DataFloat( Math.abs( self.floatValue() ) );
    }

    @Override
    public INumberData imag( INumberData self ) {
        return new DataFloat();
    }

    @Override
    public INumberData real( INumberData self ) {
        return new DataFloat( self );
    }

    @Override
    public INumberData floor( INumberData self ) {
        return new DataFloat( (float) Math.floor( self.floatValue() ) );
    }

    @Override
    public INumberData ceil( INumberData self ) {
        return new DataFloat( (float) Math.ceil( self.floatValue() ) );
    }

    @Override
    public INumberData round( INumberData self ) {
        return new DataFloat( Math.round( self.floatValue() ) );
    }

    @Override
    public INumberData leftShift( INumberData self, int amount ) {
        return new DataFloat( self.intValue() << amount );
    }

    @Override
    public INumberData rightShiftSigned( INumberData self, int amount ) {
        return new DataFloat( self.intValue() >> amount );
    }

    @Override
    public INumberData rightShiftUnsigned( INumberData self, int amount ) {
        return new DataFloat( self.intValue() >>> amount );
    }

    @Override
    public INumberData leftRotate( INumberData self, int amount ) {
        return new DataFloat( Integer.rotateLeft( self.intValue(), amount ) );
    }

    @Override
    public INumberData rightRotate( INumberData self, int amount ) {
        return new DataFloat( Integer.rotateRight( self.intValue(), amount ) );
    }

    @Override
    public INumberData bitNot( INumberData self ) {
        return new DataFloat( ~ self.intValue() );
    }

    @Override
    public INumberData bitFlip( INumberData self ) {
        return new DataFloat( Integer.reverse( self.intValue() ) );
    }

    @Override
    public INumberData bitCount( INumberData self ) {
        return new DataFloat( Integer.bitCount( self.intValue() ) );
    }

    @Override
    public INumberData binarySwap( INumberData self ) {
        return new DataFloat( Float.intBitsToFloat( self.intValue() ) );
    }

    @Override
    public INumberData bitOr( INumberData self, INumberData other ) {
        return new DataFloat( self.intValue() | other.intValue() );
    }

    @Override
    public INumberData bitAnd( INumberData self, INumberData other ) {
        return new DataFloat( self.intValue() & other.intValue() );
    }

    @Override
    public INumberData bitXor( INumberData self, INumberData other ) {
        return new DataFloat( self.intValue() ^ other.intValue() );
    }

    @Override
    public INumberData inst( byte n ) {
        return new DataFloat( n );
    }

    @Override
    public INumberData inst( short n ) {
        return new DataFloat( n );
    }

    @Override
    public INumberData inst( int n ) {
        return new DataFloat( n );
    }

    @Override
    public INumberData inst( long n ) {
        return new DataFloat( n );
    }

    @Override
    public INumberData inst( float n ) {
        return new DataFloat( n );
    }

    @Override
    public INumberData inst( double n ) {
        return new DataFloat( (float) n );
    }

    @Override
    public boolean isFloatingPoint() {
        return false;
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public String type() {
        return "float";
    }
}
