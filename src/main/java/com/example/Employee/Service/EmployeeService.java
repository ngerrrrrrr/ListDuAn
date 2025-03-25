package com.example.Employee.Service;

import com.example.Employee.DTO.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAll();

    EmployeeDto updateEmployee(Long id, EmployeeDto updateEmployee);

    void deleteEmployee(Long id);
}
