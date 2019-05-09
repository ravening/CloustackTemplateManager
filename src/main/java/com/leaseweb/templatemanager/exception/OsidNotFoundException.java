package com.leaseweb.templatemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OsidNotFoundException extends RuntimeException {
    public OsidNotFoundException() {
        super();
    }

    public OsidNotFoundException(String message) {
        super(message);
    }
}
