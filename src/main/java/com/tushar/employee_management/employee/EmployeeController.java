package com.tushar.employee_management.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.employee_management.dto.EmployeeRequestDTO;
import com.tushar.employee_management.dto.EmployeeResponseDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import jakarta.validation.Valid;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(
            EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeResponseDTO> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public EmployeeResponseDTO createEmployee(
            @Valid @RequestBody EmployeeRequestDTO request) {

        return employeeService.createEmployee(request);
    }

    @GetMapping("/employees/{id}")
    public EmployeeResponseDTO getEmployeeById(
            @PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(
            @PathVariable Long id) {

        return employeeService.deleteEmployee(id);

    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }
}