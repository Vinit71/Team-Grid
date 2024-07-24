package com.vinitspring.fullstack_backend.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        //used to call the method of the super class
        super("Employee with id " + id + " not found");
    }
}
