package cyen.data.error.constructive;

import cyen.bytecode.ExecContext;
import cyen.data.CyenConstructive;
import cyen.data.DataUtil;
import cyen.data.ICyenData;
import cyen.data.error.CyenTypeError;

public class CyenTypeErrorClass extends CyenConstructive {
    public CyenTypeErrorClass( ExecContext ctx ) {
        super( ctx );
    }

    @Override
    public ICyenData instantiate( ExecContext ctx, ICyenData... args ) {
        if( args.length <= 0 ) {
            return new CyenTypeError( ctx, null );
        }
        if( args.length == 1 ) {
            return new CyenTypeError( ctx, DataUtil.stringify( ctx, args[ 0 ] ) );
        }
        return new CyenTypeError( ctx, DataUtil.stringify( ctx, args[ 0 ] ), DataUtil.tryGetErrorOrWrap( ctx, args[ 1 ] ) );
    }

    @Override
    public String getName() {
        return "TypeError";
    }
}
