package com.syscode.saas_erp.exceptions;

import java.io.Serial;

public class DataIntegrityViolationException extends RuntimeException {
    
    @Serial
    private static final long serialVersionUID = 1l;
    
    public DataIntegrityViolationException(String message) {
        super(message);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

}
