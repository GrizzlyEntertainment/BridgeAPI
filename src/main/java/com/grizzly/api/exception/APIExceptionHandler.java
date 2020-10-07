package com.grizzly.api.exception;

import com.grizzly.api.exception.impl.APIAuthorizationException;
import com.grizzly.api.exception.impl.APIRequestEmptyResultException;
import com.grizzly.api.exception.impl.APIRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Handler used for processing of each {@link APIException}
 *  through unauthorized, or improper requests coming from the client.
 */
@ControllerAdvice
public class APIExceptionHandler {

    /**
     * Exception Handler for {@link APIRequestException}
     *      thrown when the client has a malfunction / improper request.
     * @param e
     * @return the response of the improper request action
     */
    @ExceptionHandler(value = {APIRequestException.class})
    public ResponseEntity<Object> handleAPIRequestException(APIRequestException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        APIException exception = new APIException(e.getMessage(), status, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(exception, status);
    }

    /**
     * Exception Handler for {@link APIAuthorizationException}
     *      thrown when the client is unauthorized to retrieve a certain request.
     * @param e
     * @return the response of the unauthorized request
     */
    @ExceptionHandler(value = {APIAuthorizationException.class})
    public ResponseEntity<Object> handleAPIAuthorizationException(APIAuthorizationException e) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        APIException exception = new APIException(e.getMessage(), status, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(exception, status);
    }

    /**
     * Exception Handler for {@link APIRequestEmptyResultException}
     *      thrown when the client is requesting invalid data
     *          i.e No found results in database.
     * @param e
     * @return the response of an empty result request
     */
    @ExceptionHandler(value = {APIRequestEmptyResultException.class})
    public ResponseEntity<Object> handleAPIAuthorizationException(APIRequestEmptyResultException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        APIException exception = new APIException(e.getMessage(), status, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(exception, status);
    }

}
