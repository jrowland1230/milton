package com.milton.clientapplication.exception;

import com.milton.clientapplication.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ServiceErrorHandler extends ResponseEntityExceptionHandler {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    @ExceptionHandler(MiltonClientException.class)
    public final ResponseEntity<Object> handlerException(MiltonClientException ex) {

        log.error(ex.code.getErrCode(), ex.message, ex);
        return new ResponseEntity<>(new ErrorResponse(ex.httpStatus, ex.code.getErrCode(),
                ex.code.getErrorDescription(), ex.message, simpleDateFormat.format(new Date())),
                new HttpHeaders(), ex.httpStatus);
    }
}
