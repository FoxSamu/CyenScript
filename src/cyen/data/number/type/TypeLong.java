package cyen.data.number.type;

import cyen.data.number.INumberData;
import cyen.data.number.INumberType;
import cyen.data.number.data.DataLong;

public class TypeLong implements INumberType {
    @Override
    public INumberData add( INumberData self, INumberData other ) {
        return new DataLong( self.longValue() + other.longValue() );
    }

    @Override
    public INumberData sub( INumberData self, INumberData other ) {
        return new DataLong( self.longValue() - other.longValue() );
    }

    @Override
    public INumberData mul( INumberData self, INumberData other ) {
        return new DataLong( self.longValue() * other.longValue() );
    }

    @Override
    public INumberData div( INumberData self, INumberData other ) {
        return new DataLong( self.longValue() / other.longValue() );
    }

    @Override
    public INumberData floorDiv( INumberData self, INumberData other ) {
        return new DataLong( self.longValue() / other.longValue() );
    }

    @Override
    public INumberData mod( INumberData self, INumberData other ) {
        return new DataLong( self.longValue() % other.longValue() );
    }

    @Override
    public INumberData pow( INumberData self, INumberData other ) {
        return new DataLong( (long) Math.pow( self.longValue(), other.longValue() ) );
    }

    @Override
    public INumberData neg( INumberData self ) {
        return new DataLong( - self.longValue() );
    }

    @Override
    public INumberData abs( INumberData self ) {
        return new DataLong( Math.abs( self.longValue() ) );
    }

    @Override
    public INumberData imag( INumberData self ) {
        return new DataLong();
    }

    @Override
    public INumberData real( INumberData self ) {
        return new DataLong( self );
    }

    @Override
    public INumberData floor( INumberData self ) {
        return new DataLong( self.longValue() );
    }

    @Override
    public INumberData ceil( INumberData self ) {
        return new DataLong( self.longValue() );
    }

    @Override
    public INumberData round( INumberData self ) {
        return new DataLong( self.longValue() );
    }

    @Override
    public INumberData leftShift( INumberData self, int amount ) {
        return new DataLong( self.longValue() << amount );
    }

    @Override
    public INumberData rightShiftSigned( INumberData self, int amount ) {
        return new DataLong( self.longValue() >> amount );
    }

    @Override
    public INumberData rightShiftUnsigned( INumberData self, int amount ) {
        return new DataLong( self.longValue() >>> amount );
    }

    @Override
    public INumberData bitNot( INumberData self ) {
        return new DataLong( ~ self.longValue() );
    }

    @Override
    public INumberData bitOr( INumberData self, INumberData other ) {
        return new DataLong( self.longValue() | other.longValue() );
    }

    @Override
    public INumberData bitAnd( INumberData self, INumberData other ) {
        return new DataLong( self.longValue() & other.longValue() );
    }

    @Override
    public INumberData bitXor( INumberData self, INumberData other ) {
        return new DataLong( self.longValue() ^ other.longValue() );
    }

    @Override
    public INumberData inst( byte n ) {
        return new DataLong( n );
    }

    @Override
    public INumberData inst( short n ) {
        return new DataLong( n );
    }

    @Override
    public INumberData inst( int n ) {
        return new DataLong( n );
    }

    @Override
    public INumberData inst( long n ) {
        return new DataLong( n );
    }

    @Override
    public INumberData inst( float n ) {
        return new DataLong( (long) n );
    }

    @Override
    public INumberData inst( double n ) {
        return new DataLong( (long) n );
    }

    @Override
    public boolean isFloatingPoint() {
        return false;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public String type() {
        return "long";
    }
}
