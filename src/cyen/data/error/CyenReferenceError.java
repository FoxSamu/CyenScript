package cyen.data.error;

import cyen.bytecode.ExecContext;

public class CyenReferenceError extends CyenError {
    public CyenReferenceError( ExecContext ctx, String errorMessage, CyenError cause ) {
        super( ctx, errorMessage, cause );
    }

    public CyenReferenceError( ExecContext ctx, String errorMessage ) {
        super( ctx, errorMessage );
    }

    public String getErrorName() {
        return "ReferenceError";
    }
}
