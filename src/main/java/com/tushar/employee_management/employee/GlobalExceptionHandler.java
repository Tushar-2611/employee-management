package com.tushar.employee_management.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Map;
import java.util.Optional;

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

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public Map<String, String> handleValidationErrors(
                        MethodArgumentNotValidException ex) {

                String errorMessage = Optional.ofNullable(
                                ex.getBindingResult().getFieldError())
                                .map(fieldError -> fieldError.getDefaultMessage())
                                .orElse("Validation failed");

                return Map.of(
                                "message",
                                errorMessage);
        }
}