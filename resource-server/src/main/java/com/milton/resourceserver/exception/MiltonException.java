package com.milton.resourceserver.exception;

import com.milton.resourceserver.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

public class MiltonException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public final HttpStatus httpStatus;
    public final ErrorCode code;
    public final String message;
    @Getter
    private final Throwable exception;

    public MiltonException(HttpStatus httpStatus, ErrorCode code, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.exception = null;
    }

    public MiltonException(HttpStatus httpStatus, ErrorCode code, String message, Throwable exception) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.exception = exception;
    }
}
