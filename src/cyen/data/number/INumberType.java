package cyen.data.number;

public interface INumberType {
    INumberData add( INumberData self, INumberData other );
    INumberData sub( INumberData self, INumberData other );
    INumberData mul( INumberData self, INumberData other );
    INumberData div( INumberData self, INumberData other );
    INumberData floorDiv( INumberData self, INumberData other );
    INumberData mod( INumberData self, INumberData other );
    INumberData pow( INumberData self, INumberData other );

    INumberData neg( INumberData self );
    INumberData abs( INumberData self );

    INumberData imag( INumberData self );
    INumberData real( INumberData self );

    INumberData floor( INumberData self );
    INumberData ceil( INumberData self );
    INumberData round( INumberData self );

    INumberData leftShift( INumberData self, int amount );
    INumberData rightShiftSigned( INumberData self, int amount );
    INumberData rightShiftUnsigned( INumberData self, int amount );

    INumberData leftRotate( INumberData self, int amount );
    INumberData rightRotate( INumberData self, int amount );

    INumberData bitOr( INumberData self, INumberData other );
    INumberData bitAnd( INumberData self, INumberData other );
    INumberData bitXor( INumberData self, INumberData other );

    INumberData bitNot( INumberData self );
    INumberData bitFlip( INumberData self );
    INumberData bitCount( INumberData self );

    INumberData binarySwap( INumberData self );

    INumberData inst( byte n );
    INumberData inst( short n );
    INumberData inst( int n );
    INumberData inst( long n );
    INumberData inst( float n );
    INumberData inst( double n );

    boolean isFloatingPoint();

    int getLevel();

    String type();
}
