package com.grizzly.api.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * Classed used to identify the meta-data of the APIException.
 */
@Data
@RequiredArgsConstructor
public class APIException {

    /**
     * Represents the API Request Exception Message
     */
    private final String message;

    /**
     * Represents the API Request Exception HTTP Status
     */
    private final HttpStatus httpStatus;

    /**
     * Represents the API Request Exception timestamp of when it was thrown.
     */
    private final ZonedDateTime timestamp;
}
