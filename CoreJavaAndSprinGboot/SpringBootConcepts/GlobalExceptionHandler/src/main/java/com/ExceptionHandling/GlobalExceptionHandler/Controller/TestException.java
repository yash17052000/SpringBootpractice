package com.ExceptionHandling.GlobalExceptionHandler.Controller;

public class TestException extends RuntimeException {
    public TestException(String message) {
        super(message);
    }
}
