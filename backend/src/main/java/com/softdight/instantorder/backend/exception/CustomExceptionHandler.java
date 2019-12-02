package com.softdight.instantorder.backend.exception;

import com.softdight.instantorder.backend.exception.types.InstantOrderException;
import com.softdight.instantorder.backend.exception.types.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice()
public class CustomExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final ConstraintViolationException ex) {
        return getResponse(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final EntityNotFoundException ex) {
        return getResponse(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final AuthenticationException ex) {
        return getResponse(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final InstantOrderException ex) {
        return getResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handle(final Exception ex) {
        return getResponse(HttpStatus.BAD_REQUEST, ex);
    }

    private ResponseEntity<ErrorResponse> getResponse(final HttpStatus status, final Exception ex) {
        final ErrorResponse errorResponse = new ErrorResponse(
                status,
                ex.getMessage(),
                LocalDateTime.now());

        LOGGER.error(ex.getMessage(), ex);

        return new ResponseEntity<>(errorResponse, status);
    }

}
