package com.edu.testpb.taskrepo.exceptions;

public class TaskItemNotFoundException extends RuntimeException {

    public TaskItemNotFoundException() {
    }

    public TaskItemNotFoundException(String message) {
        super(message);
    }

    public TaskItemNotFoundException(Throwable cause) {
        super(cause);
    }

    public TaskItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskItemNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
