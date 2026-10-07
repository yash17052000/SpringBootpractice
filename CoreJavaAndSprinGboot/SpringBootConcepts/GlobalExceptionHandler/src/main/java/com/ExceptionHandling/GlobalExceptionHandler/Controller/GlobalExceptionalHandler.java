package com.ExceptionHandling.GlobalExceptionHandler.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {TestController.class,TestController2.class})
public class GlobalExceptionalHandler {

    @ExceptionHandler(ArithmeticException.class)
    public  ResponseEntity<String> handleArthimeticException(ArithmeticException e){
        return  new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_CONTENT);
    }
    @ExceptionHandler(TestException.class)
    public  String handleTestExcpetion(TestException e){
        return  e.getMessage();
    }
    @ExceptionHandler(NullPointerException.class)
    public  String handleNullPointerException(NullPointerException e){
        return  e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e){
        return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
