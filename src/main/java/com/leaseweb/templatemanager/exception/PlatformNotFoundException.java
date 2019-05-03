package com.leaseweb.templatemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlatformNotFoundException extends RuntimeException {
    public PlatformNotFoundException() {
        super();
    }

    public PlatformNotFoundException(String message) {
        super(message);
    }
}
