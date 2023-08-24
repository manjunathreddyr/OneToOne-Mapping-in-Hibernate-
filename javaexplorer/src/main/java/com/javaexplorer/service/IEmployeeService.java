package com.javaexplorer.service;

import com.javaexplorer.domain.Employee;
import com.javaexplorer.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {

    Employee createEmployee(EmployeeDto employeeDto);
    Employee updateEmployee(EmployeeDto employeeDto,Long employeeId);
    Employee fetchEmployeeById(Long employeeId);
    List<Employee> fetchAllEmployees();
    void deleteEmployee(Long employeeId);
}
