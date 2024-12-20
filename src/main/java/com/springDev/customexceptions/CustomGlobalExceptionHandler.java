package com.springDev.customexceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
       CustomErrorDetails errorDetails=new CustomErrorDetails(new Date(),"Method not applicable",ex.getMessage());

       return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),"Http method patch not supported",ex.getMessage());
        return new ResponseEntity<>(customErrorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNameNotFoundException.class)
    public final ResponseEntity<Object> handleHttpRequestUserNameNotFound(UserNameNotFoundException ex,WebRequest request){
        CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(customErrorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolatedExecption(ConstraintViolationException ex,WebRequest request){
        CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(customErrorDetails,HttpStatus.BAD_REQUEST);
    }
}
