package com.edu.testpb.taskrepo.exceptions;

public class UsersNotFoundException extends RuntimeException {

    public UsersNotFoundException() {
    }

    public UsersNotFoundException(String message) {
        super(message);
    }

    public UsersNotFoundException(Throwable cause) {
        super(cause);
    }

    public UsersNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsersNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
