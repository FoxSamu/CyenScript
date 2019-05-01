package cyen.data.error;

import cyen.bytecode.ExecContext;

public class CyenInternalError extends CyenError {
    public CyenInternalError( ExecContext ctx, String errorMessage, CyenError cause ) {
        super( ctx, errorMessage, cause );
    }

    public CyenInternalError( ExecContext ctx, String errorMessage ) {
        super( ctx, errorMessage );
    }

    public String getErrorName() {
        return "InternalError";
    }

    @Override
    public boolean canCatch() {
        return false;
    }
}
