package com.tushar.employee_management.employee;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found"));
    }

    public Employee createEmployee(Employee employee) {

        if (employee.getName().isBlank()) {
            throw new EmployeeValidationException(
                    "Name cannot be empty");
        }

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(
            Long id,
            Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found"));
        if (employee.getName().isBlank()) {
            throw new EmployeeValidationException(
                    "Name cannot be empty");
        }
        employee.setName(updatedEmployee.getName());
        employee.setDepartment(
                updatedEmployee.getDepartment());

        return employeeRepository.save(employee);
    }

    public String deleteEmployee(
            Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found"));

        employeeRepository.delete(employee);
        return "Employee deleted successfully";

    }

}