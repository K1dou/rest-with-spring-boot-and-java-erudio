package com.K1dou.restwithspringbootandjava.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 7240027076853673008L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
