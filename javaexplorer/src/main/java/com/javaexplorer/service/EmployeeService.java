package com.javaexplorer.service;

import com.javaexplorer.domain.Employee;
import com.javaexplorer.domain.Passport;
import com.javaexplorer.dto.EmployeeDto;
import com.javaexplorer.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Passport passport = new Passport();
        passport.setPassportNo(employeeDto.getPassportNo());

        Employee employee = new Employee();
        employee.setPassport(passport);
        employee.setName(employeeDto.getName());

        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto, Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("employee not found"));
        Passport passport = employee.getPassport();
        passport.setPassportNo(employeeDto.getPassportNo());

        employee.setName(employeeDto.getName());
        employee.setPassport(passport);

        return employeeRepo.save(employee);
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) {
        return employeeRepo.findById(employeeId)
                .orElseThrow(()-> new RuntimeException("employee not found"));
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void deleteEmployee(Long employeeId) {
       employeeRepo.deleteById(employeeId);
    }
}
