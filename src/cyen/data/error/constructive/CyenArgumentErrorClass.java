package cyen.data.error.constructive;

import cyen.bytecode.ExecContext;
import cyen.data.CyenConstructive;
import cyen.data.DataUtil;
import cyen.data.ICyenData;
import cyen.data.error.CyenArgumentError;

public class CyenArgumentErrorClass extends CyenConstructive {
    public CyenArgumentErrorClass( ExecContext ctx ) {
        super( ctx );
    }

    @Override
    public ICyenData instantiate( ExecContext ctx, ICyenData... args ) {
        if( args.length <= 0 ) {
            return new CyenArgumentError( ctx, null );
        }
        if( args.length == 1 ) {
            return new CyenArgumentError( ctx, DataUtil.stringify( ctx, args[ 0 ] ) );
        }
        return new CyenArgumentError( ctx, DataUtil.stringify( ctx, args[ 0 ] ), DataUtil.tryGetErrorOrWrap( ctx, args[ 1 ] ) );
    }

    @Override
    public String getName() {
        return "ArgumentError";
    }
}
