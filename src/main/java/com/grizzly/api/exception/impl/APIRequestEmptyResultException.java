package com.grizzly.api.exception.impl;

/**
 * Creates a custom Exception used for handling API Request Exceptions
 */
public class APIRequestEmptyResultException extends RuntimeException {


    /**
     *
     * @param message
     */
    public APIRequestEmptyResultException(String message) {
        super(message);
    }

    /**
     * Creates a new API Request Exception with a throwable cause
     * @param message
     * @param cause
     */
    public APIRequestEmptyResultException(String message, Throwable cause) {
        super(message, cause);
    }

}
