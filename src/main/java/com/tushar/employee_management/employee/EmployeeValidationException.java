package com.tushar.employee_management.employee;

public class EmployeeValidationException
        extends RuntimeException {

    public EmployeeValidationException(String message) {
        super(message);
    }
}