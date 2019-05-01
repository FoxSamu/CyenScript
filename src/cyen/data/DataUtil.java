package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.data.error.CyenError;

public class DataUtil {
    public static boolean isNull( ICyenData data ) {
        return data == null;
    }

    public static String stringify( ExecContext ctx, ICyenData data ) {
        return data == null ? "null" : data.stringify( ctx );
    }

    public static CyenError tryGetErrorOrWrap( ExecContext ctx, ICyenData error ) {
        if( ! ( error instanceof CyenError ) ) {
            return new CyenError( ctx, error.stringify( ctx ) );
        }
        return (CyenError) error;
    }

    public static boolean booleanize( ExecContext ctx, ICyenData data ) {
        return data != null && data.booleanize( ctx );
    }
}
