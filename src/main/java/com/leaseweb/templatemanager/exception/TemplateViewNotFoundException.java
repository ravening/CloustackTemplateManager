package com.leaseweb.templatemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TemplateViewNotFoundException extends RuntimeException {
    public TemplateViewNotFoundException() {
        super();
    }

    public TemplateViewNotFoundException(String message) {
        super(message);
    }
}
