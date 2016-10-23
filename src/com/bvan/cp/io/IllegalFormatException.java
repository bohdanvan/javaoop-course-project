package com.bvan.cp.io;

/**
 * @author bvanchuhov
 */
public class IllegalFormatException extends RuntimeException {

    public IllegalFormatException(String message) {
        super(message);
    }

    public IllegalFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFormatException(Throwable cause) {
        super(cause);
    }
}
