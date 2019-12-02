package com.softdight.instantorder.backend.exception.types;

public class InstantOrderException extends RuntimeException {

    public InstantOrderException() {
    }

    public InstantOrderException(String message) {
        super(message);
    }

    public InstantOrderException(Throwable cause) {
        super(cause);
    }

    public InstantOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstantOrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
