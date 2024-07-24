package com.vinitspring.fullstack_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice is used to create 'global exception handler'
@ControllerAdvice
public class EmployeeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)  // to handle EmployeeNotFoundException
    @ResponseStatus(HttpStatus.NOT_FOUND)   //it will set HTTP status to 404 Not Found.
    public Map<String,String> exceptionHandler(EmployeeNotFoundException exception){
            Map<String,String> map = new HashMap<>();   // It will create a new empty map for storing error details
            map.put("errorMessage", exception.getMessage());
            return map;
    }
}
