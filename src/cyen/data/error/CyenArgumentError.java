package cyen.data.error;

import cyen.bytecode.ExecContext;

public class CyenArgumentError extends CyenError {
    public CyenArgumentError( ExecContext ctx, String errorMessage, CyenError cause ) {
        super( ctx, errorMessage, cause );
    }

    public CyenArgumentError( ExecContext ctx, String errorMessage ) {
        super( ctx, errorMessage );
    }

    public String getErrorName() {
        return "ArgumentError";
    }
}
