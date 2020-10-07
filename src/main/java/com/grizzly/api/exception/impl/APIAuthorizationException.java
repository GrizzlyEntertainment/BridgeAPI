package com.grizzly.api.exception.impl;

/**
 * Creates a custom Exception used for handling API Request Exceptions
 */
public class APIAuthorizationException extends RuntimeException {


    /**
     *
     * @param message
     */
    public APIAuthorizationException(String message) {
        super(message);
    }

    /**
     * Creates a new API Request Exception with a throwable cause
     * @param message
     * @param cause
     */
    public APIAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

}
