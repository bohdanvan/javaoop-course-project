package com.bvan.cp.oop.io;

/**
 * @author bvanchuhov
 */
public class IllegalFormatException extends Exception {

    public IllegalFormatException(String message) {
        super(message);
    }

    public IllegalFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
