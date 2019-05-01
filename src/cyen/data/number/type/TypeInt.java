package cyen.data.number.type;

import cyen.data.number.INumberData;
import cyen.data.number.INumberType;
import cyen.data.number.data.DataInt;

public class TypeInt implements INumberType {
    @Override
    public INumberData add( INumberData self, INumberData other ) {
        return new DataInt( self.intValue() + other.intValue() );
    }

    @Override
    public INumberData sub( INumberData self, INumberData other ) {
        return new DataInt( self.intValue() - other.intValue() );
    }

    @Override
    public INumberData mul( INumberData self, INumberData other ) {
        return new DataInt( self.intValue() * other.intValue() );
    }

    @Override
    public INumberData div( INumberData self, INumberData other ) {
        return new DataInt( self.intValue() / other.intValue() );
    }

    @Override
    public INumberData floorDiv( INumberData self, INumberData other ) {
        return new DataInt( self.intValue() / other.intValue() );
    }

    @Override
    public INumberData mod( INumberData self, INumberData other ) {
        return new DataInt( self.intValue() % other.intValue() );
    }

    @Override
    public INumberData pow( INumberData self, INumberData other ) {
        return new DataInt( (int) Math.pow( self.intValue(), other.intValue() ) );
    }

    @Override
    public INumberData neg( INumberData self ) {
        return new DataInt( - self.intValue() );
    }

    @Override
    public INumberData abs( INumberData self ) {
        return new DataInt( Math.abs( self.intValue() ) );
    }

    @Override
    public INumberData imag( INumberData self ) {
        return new DataInt();
    }

    @Override
    public INumberData real( INumberData self ) {
        return new DataInt( self );
    }

    @Override
    public INumberData floor( INumberData self ) {
        return new DataInt( self.intValue() );
    }

    @Override
    public INumberData ceil( INumberData self ) {
        return new DataInt( self.intValue() );
    }

    @Override
    public INumberData round( INumberData self ) {
        return new DataInt( self.intValue() );
    }

    @Override
    public INumberData leftShift( INumberData self, int amount ) {
        return new DataInt( self.intValue() << amount );
    }

    @Override
    public INumberData rightShiftSigned( INumberData self, int amount ) {
        return new DataInt( self.intValue() >> amount );
    }

    @Override
    public INumberData rightShiftUnsigned( INumberData self, int amount ) {
        return new DataInt( self.intValue() >>> amount );
    }

    @Override
    public INumberData bitNot( INumberData self ) {
        return new DataInt( ~ self.intValue() );
    }

    @Override
    public INumberData bitOr( INumberData self, INumberData other ) {
        return new DataInt( self.intValue() | other.intValue() );
    }

    @Override
    public INumberData bitAnd( INumberData self, INumberData other ) {
        return new DataInt( self.intValue() & other.intValue() );
    }

    @Override
    public INumberData bitXor( INumberData self, INumberData other ) {
        return new DataInt( self.intValue() ^ other.intValue() );
    }

    @Override
    public INumberData inst( byte n ) {
        return new DataInt( n );
    }

    @Override
    public INumberData inst( short n ) {
        return new DataInt( n );
    }

    @Override
    public INumberData inst( int n ) {
        return new DataInt( n );
    }

    @Override
    public INumberData inst( long n ) {
        return new DataInt( (int) n );
    }

    @Override
    public INumberData inst( float n ) {
        return new DataInt( (int) n );
    }

    @Override
    public INumberData inst( double n ) {
        return new DataInt( (int) n );
    }

    @Override
    public boolean isFloatingPoint() {
        return false;
    }

    @Override
    public int getLevel() {
        return 2;
    }

    @Override
    public String type() {
        return "int";
    }
}
