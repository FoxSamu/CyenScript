package cyen.util;

public class ArithmeticUtils {
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
}
