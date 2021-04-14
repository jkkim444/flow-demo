package com.encocns.enfra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "login session is null")
public class EnfraNoLoginException extends RuntimeException {
    
    private static final long serialVersionUID = -715553820827982583L;

    public EnfraNoLoginException() {
    }

    public EnfraNoLoginException(String errorMsg) {
        super(errorMsg);
    }

}
