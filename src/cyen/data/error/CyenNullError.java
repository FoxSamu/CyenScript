package cyen.data.error;

import cyen.bytecode.ExecContext;

public class CyenNullError extends CyenError {
    public CyenNullError( ExecContext ctx, String errorMessage, CyenError cause ) {
        super( ctx, errorMessage, cause );
    }

    public CyenNullError( ExecContext ctx, String errorMessage ) {
        super( ctx, errorMessage );
    }

    public String getErrorName() {
        return "NullError";
    }
}
