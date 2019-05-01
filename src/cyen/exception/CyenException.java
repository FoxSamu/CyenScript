package cyen.exception;

/**
 * The main exception for cyen parsing and executing. This class is a {@link RuntimeException} for convenience in code
 * (e.g. there's no need for making almost every method in this library throw this exception). The engine catches this
 * exception automatically and throws a not-{@link RuntimeException} instead.
 *
 * The actual {@code CyenException} is never thrown at all. It instead has some subclasses to distinguish errors, and to
 * pass extra data to the exception.
 */
public class CyenException extends RuntimeException {
    public CyenException() {
        super();
    }

    public CyenException( String message ) {
        super( message );
    }

    public CyenException( String message, Throwable cause ) {
        super( message, cause );
    }

    public CyenException( Throwable cause ) {
        super( cause );
    }

    public CyenException( String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace ) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
