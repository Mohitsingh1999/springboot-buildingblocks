package com.springDev.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class CustomeGlobalRestControllerAdviceExceptionHandler {

    @ExceptionHandler(UserNameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorDetails handleUserNameNotFound(UserNameNotFoundException ex){
        return new CustomErrorDetails(new Date(),"Custome excpeton from @RestControllerAdvice",ex.getMessage());


    }
}
