package com.cy.store.service.ex;

public class CartnullException extends ServiceException{
    public CartnullException() {
    }

    public CartnullException(String message) {
        super(message);
    }

    public CartnullException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartnullException(Throwable cause) {
        super(cause);
    }

    public CartnullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
