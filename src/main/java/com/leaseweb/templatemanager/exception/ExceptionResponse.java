package com.leaseweb.templatemanager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private String message;
    private HttpStatus httpStatus;

    public static ExceptionResponse of(String message, HttpStatus status) {
        return new ExceptionResponse(message, status);
    }
}
