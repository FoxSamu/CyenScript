package cyen.data.error;

import cyen.bytecode.ExecContext;
import cyen.bytecode.util.StackTrace;
import cyen.data.CyenObject;

public class CyenError extends CyenObject {
    public final String errorMessage;
    public final CyenError cause;
    public final StackTrace trace;

    public CyenError( ExecContext ctx, String errorMessage, CyenError cause ) {
        super( ctx );
        this.errorMessage = errorMessage;
        this.cause = cause;
        this.trace = ctx.getStackTrace();
    }

    public CyenError( ExecContext ctx, String errorMessage ) {
        super( ctx );
        this.errorMessage = errorMessage;
        this.cause = null;
        this.trace = ctx.getStackTrace();
    }

    public String getErrorName() {
        return "Error";
    }

    public boolean canCatch() {
        return true;
    }

    @Override
    public String stringify( ExecContext ctx ) {
        return getErrorName()
                + ( errorMessage == null ? "" : ": " + errorMessage ) + "\n"
                + trace.toString()
                + ( cause != null ? "Caused by " + cause.stringify( ctx ) : "" );
    }
}
