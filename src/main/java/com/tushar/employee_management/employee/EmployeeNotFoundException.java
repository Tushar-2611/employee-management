package com.tushar.employee_management.employee;

public class EmployeeNotFoundException
        extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}