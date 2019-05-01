package cyen.data.error.constructive;

import cyen.bytecode.ExecContext;
import cyen.data.CyenConstructive;
import cyen.data.DataUtil;
import cyen.data.ICyenData;
import cyen.data.error.CyenError;

public class CyenErrorClass extends CyenConstructive {
    public CyenErrorClass( ExecContext ctx ) {
        super( ctx );
    }

    @Override
    public ICyenData instantiate( ExecContext ctx, ICyenData... args ) {
        if( args.length <= 0 ) {
            return new CyenError( ctx, null );
        }
        if( args.length == 1 ) {
            return new CyenError( ctx, DataUtil.stringify( ctx, args[ 0 ] ) );
        }
        return new CyenError( ctx, DataUtil.stringify( ctx, args[ 0 ] ), DataUtil.tryGetErrorOrWrap( ctx, args[ 1 ] ) );
    }

    @Override
    public String getName() {
        return "Error";
    }
}
