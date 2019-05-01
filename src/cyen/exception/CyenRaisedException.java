package cyen.exception;

import cyen.bytecode.util.StackTrace;
import cyen.data.ICyenData;

public class CyenRaisedException extends CyenException {
    private final ICyenData error;
    private final StackTrace trace;

    public CyenRaisedException( ICyenData error, StackTrace trace ) {
        this.error = error;
        this.trace = trace;
    }

    public ICyenData getError() {
        return error;
    }
}
