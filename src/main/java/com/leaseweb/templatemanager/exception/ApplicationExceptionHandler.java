package com.leaseweb.templatemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(TemplateNotFoundException.class)
    public final ResponseEntity templateNotFoundException(final TemplateNotFoundException e) {
        ExceptionResponse exceptionResponse = ExceptionResponse
                .of(e.getMessage(), HttpStatus.NOT_FOUND);

        return ResponseEntity.status(exceptionResponse.getHttpStatus())
                .body(exceptionResponse);

    }

    public final ResponseEntity platformNotFoundException(final PlatformNotFoundException e) {
        ExceptionResponse exceptionResponse = ExceptionResponse
                .of(e.getMessage(), HttpStatus.NOT_FOUND);

        return ResponseEntity.status(exceptionResponse.getHttpStatus())
                .body(exceptionResponse);

    }
}
