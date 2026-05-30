package com.tushar.employee_management.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleEmployeeNotFound(
            EmployeeNotFoundException ex) {

        return Map.of(
                "message",
                ex.getMessage());
    }

    @ExceptionHandler(EmployeeValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleEmployeeValidation(
            EmployeeValidationException ex) {

        return Map.of(
                "message",
                ex.getMessage());
    }
}