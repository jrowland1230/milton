package com.milton.clientapplication.exception;

import com.milton.clientapplication.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

public class MiltonClientException extends RuntimeException{

        @Serial
        private static final long serialVersionUID = 1L;

        public final HttpStatus httpStatus;
        public final ErrorCode code;
        public final String message;
        @Getter
        private final Throwable exception;

    public MiltonClientException(HttpStatus httpStatus, ErrorCode code, String message) {
            super(message);
            this.httpStatus = httpStatus;
            this.code = code;
            this.message = message;
            this.exception = null;
        }

    public MiltonClientException(HttpStatus httpStatus, ErrorCode code, String message, Throwable exception) {
            super(message);
            this.httpStatus = httpStatus;
            this.code = code;
            this.message = message;
            this.exception = exception;
    }
}
