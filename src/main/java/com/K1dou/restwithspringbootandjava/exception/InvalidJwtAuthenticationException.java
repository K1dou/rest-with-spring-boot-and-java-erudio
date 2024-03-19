package com.K1dou.restwithspringbootandjava.exception;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationException extends AuthenticationException {
    @Serial
    private static final long serialVersionUID = -6809631682725169462L;
    public InvalidJwtAuthenticationException(String message) {
        super(message);
    }
}
