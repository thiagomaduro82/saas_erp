package com.syscode.saas_erp.exceptions;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1l;
    
    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
