package com.example.Employee.Mapper;

import com.example.Employee.DTO.EmployeeDto;
import com.example.Employee.Entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getEmail(),
                employee.getFirstName(),
                employee.getLastName()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getEmail(),
                employeeDto.getFirstName(),
                employeeDto.getLastName()
        );
    }
}
