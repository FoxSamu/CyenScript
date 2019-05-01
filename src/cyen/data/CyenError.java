package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.bytecode.util.StackTrace;

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

    @Override
    public String stringify( ExecContext ctx ) {
        return getErrorName() + ": " + errorMessage + "\n" + trace.toString() + ( cause != null ? cause.stringify( ctx ) : "" );
    }
}
