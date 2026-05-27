package com.tushar.employee_management.employee;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public Employee getEmployee() {

        return new Employee(
                1L,
                "Tushar",
                "CS Engineering");
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return List.of(
                new Employee(1L, "Tushar", "Engineering"),
                new Employee(2L, "Rahul", "HR"),
                new Employee(3L, "Priya", "Finance"));
    }
}