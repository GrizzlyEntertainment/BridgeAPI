package com.grizzly.api.exception.impl;

/**
 * Creates a custom Exception used for handling API Request Exceptions
 */
public class APIAuthorizationException extends RuntimeException {


    /**
     * Creates a new API Request Exception with the specified message of reason
     * @param message
     */
    public APIAuthorizationException(final String message) {
        super(message);
    }

    /**
     * Creates a new API Request Exception with a specified message of reason, and throwable cause
     * @param message
     * @param cause
     */
    public APIAuthorizationException(final String message, Throwable cause) {
        super(message, cause);
    }

}
