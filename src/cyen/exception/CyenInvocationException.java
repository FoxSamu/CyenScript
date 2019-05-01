package cyen.exception;

public class CyenInvocationException extends RuntimeException {
    public CyenInvocationException() {
    }

    public CyenInvocationException( String message ) {
        super( message );
    }

    public CyenInvocationException( String message, Throwable cause ) {
        super( message, cause );
    }

    public CyenInvocationException( Throwable cause ) {
        super( cause );
    }

    public CyenInvocationException( String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace ) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
