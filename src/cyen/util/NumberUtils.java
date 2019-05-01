package cyen.util;

public class NumberUtils {
    /**
     * Rounds the double as if it is converted to an integer. This rounds the number up ({@link Math#ceil}) when it is
     * negative, and down ({@link Math#floor}) when it is positive. This does not convert to an integer so that large
     * numbers could be preserved.
     * @param d The double to round.
     * @return The rounded number, as double
     */
    public static double integerRound( double d ) {
        return d < 0 ? Math.ceil( d ) : Math.floor( d );
    }

    /**
     * Rounds the float as if it is converted to an integer. This rounds the number up ({@link Math#ceil}) when it is
     * negative, and down ({@link Math#floor}) when it is positive. This does not convert to an integer so that large
     * numbers could be preserved.
     * @param d The float to round.
     * @return The rounded number, as float
     */
    public static float integerRound( float d ) {
        return d < 0 ? (float) Math.ceil( d ) : (float) Math.floor( d );
    }

    public static byte rotateRight( byte bits, int shift ) {
        return (byte) ( ( bits & 0xff ) >>> shift | ( bits & 0xff ) << 8 - shift );
    }

    public static byte rotateLeft( byte bits, int shift ) {
        return (byte) ( ( bits & 0xff ) << shift | ( bits & 0xff ) >>> 8 - shift );
    }

    public static short rotateRight( short bits, int shift ) {
        return (short) ( ( bits & 0xffff ) >>> shift | ( bits & 0xffff ) << 16 - shift );
    }

    public static short rotateLeft( short bits, int shift ) {
        return (short) ( ( bits & 0xffff ) << shift | ( bits & 0xffff ) >>> 16 - shift );
    }

    public static byte reverseBits( byte bits ) {
        return (byte) ( Integer.reverse( bits & 0xff ) >>> 24 );
    }

    public static short reverseBits( short bits ) {
        return (short) ( Integer.reverse( bits & 0xffff ) >>> 16 );
    }
}
