package com.example.firstjava.exception;

public class MsgNotFoundException extends RuntimeException {

    public MsgNotFoundException() {
    }

    public MsgNotFoundException(String message) {
        super(message);
    }

    public MsgNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MsgNotFoundException(Throwable cause) {
        super(cause);
    }

    public MsgNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
