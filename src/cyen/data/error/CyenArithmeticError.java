package cyen.data.error;

import cyen.bytecode.ExecContext;

public class CyenArithmeticError extends CyenError {
    public CyenArithmeticError( ExecContext ctx, String errorMessage, CyenError cause ) {
        super( ctx, errorMessage, cause );
    }

    public CyenArithmeticError( ExecContext ctx, String errorMessage ) {
        super( ctx, errorMessage );
    }

    public String getErrorName() {
        return "ArithmeticError";
    }
}
