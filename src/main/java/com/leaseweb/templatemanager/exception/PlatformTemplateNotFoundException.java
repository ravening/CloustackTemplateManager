package com.leaseweb.templatemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlatformTemplateNotFoundException extends RuntimeException {
    public PlatformTemplateNotFoundException() {
        super();
    }

    public PlatformTemplateNotFoundException(String message) {
        super(message);
    }
}
