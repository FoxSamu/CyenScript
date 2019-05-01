package cyen.data.error;

import cyen.bytecode.ExecContext;

public class CyenTypeError extends CyenError {
    public CyenTypeError( ExecContext ctx, String errorMessage, CyenError cause ) {
        super( ctx, errorMessage, cause );
    }

    public CyenTypeError( ExecContext ctx, String errorMessage ) {
        super( ctx, errorMessage );
    }

    public String getErrorName() {
        return "TypeError";
    }
}
