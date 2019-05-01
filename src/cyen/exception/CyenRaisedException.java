package cyen.exception;

import cyen.bytecode.ExecContext;
import cyen.bytecode.util.StackTrace;
import cyen.data.ICyenData;

/**
 * This exception is thrown during execution, when the script throws an error that's never catched.
 */
public class CyenRaisedException extends CyenException {
    private final ICyenData error;
    private final ExecContext throwerContext;

    public CyenRaisedException( ICyenData error, StackTrace trace, ExecContext context ) {
        this.error = error;
        this.throwerContext = context;
    }

    public ExecContext getThrowerContext() {
        return throwerContext;
    }

    public ICyenData getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return "Cyen script raised an error.\nUncaught " + error.stringify( throwerContext );
    }
}
