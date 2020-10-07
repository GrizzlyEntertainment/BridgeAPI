package com.grizzly.api.exception.impl;

/**
 * Creates a custom Exception used for handling API Request Exceptions
 */
public class APIRequestException extends RuntimeException {


    /**
     *
     * @param message
     */
    public APIRequestException(String message) {
        super(message);
    }

    /**
     * Creates a new API Request Exception with a throwable cause
     * @param message
     * @param cause
     */
    public APIRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
