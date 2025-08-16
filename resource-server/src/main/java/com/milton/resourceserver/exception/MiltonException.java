package com.milton.resourceserver.exception;

public class MiltonException extends RuntimeException{
    public MiltonException() {
    }

    public MiltonException(String message) {
        super(message);
    }

    public MiltonException(String message, Throwable cause) {
        super(message, cause);
    }
}
