package com.tushar.employee_management.employee;

import org.springframework.stereotype.Service;

import com.tushar.employee_management.dto.EmployeeRequestDTO;
import com.tushar.employee_management.dto.EmployeeResponseDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDTO> responseList = new ArrayList<>();
        for (Employee employee : employees) {

            EmployeeResponseDTO response = new EmployeeResponseDTO();

            response.setId(employee.getId());
            response.setName(employee.getName());
            response.setDepartment(employee.getDepartment());

            responseList.add(response);
        }

        return responseList;
    }

    public EmployeeResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found"));
        EmployeeResponseDTO response = new EmployeeResponseDTO();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setDepartment(employee.getDepartment());
        return response;

    }

    public EmployeeResponseDTO createEmployee(
            EmployeeRequestDTO request) {

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setDepartment(request.getDepartment());

        employee = employeeRepository.save(employee);

        EmployeeResponseDTO response = new EmployeeResponseDTO();

        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setDepartment(employee.getDepartment());

        return response;
    }

    public Employee updateEmployee(
            Long id,
            Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found"));
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