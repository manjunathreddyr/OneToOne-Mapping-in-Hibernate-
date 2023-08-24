package com.javaexplorer.controller;


import com.javaexplorer.domain.Employee;
import com.javaexplorer.dto.EmployeeDto;
import com.javaexplorer.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/employee")
    public Map<String,Object> createEmployee(@RequestBody EmployeeDto employeeDto){
        Map<String,Object> map = new HashMap<>();

        try{
           Employee employee =  employeeService.createEmployee(employeeDto);
           map.put("data", employee);
           map.put("status","success");

        }catch (Exception e){
            map.put("status", e.getMessage());
        }

        return map;
    }

    @PutMapping("/employee")
    public Map<String,Object> updateEmployee(@RequestBody EmployeeDto employeeDto,@RequestParam Long employeeId){
        Map<String,Object> map = new HashMap<>();

        try{
            Employee employee =  employeeService.updateEmployee(employeeDto, employeeId);
            map.put("data", employee);
            map.put("status","success");

        }catch (Exception e){
            map.put("status", e.getMessage());
        }

        return map;
    }

    @GetMapping("/employee/{id}")
    public Map<String,Object> getEmployeeById(@PathVariable Long id){
        Map<String,Object> map = new HashMap<>();

        try{
            Employee employee =  employeeService.fetchEmployeeById(id);
            map.put("data", employee);
            map.put("status","success");

        }catch (Exception e){
            map.put("status", e.getMessage());
        }

        return map;
    }

    @GetMapping("/employees")
    public Map<String,Object> getAllEmployees(){
        Map<String,Object> map = new HashMap<>();

        try{
            List<Employee> employeesList =  employeeService.fetchAllEmployees();
            map.put("data", employeesList);
            map.put("status","success");

        }catch (Exception e){
            map.put("status", e.getMessage());
        }

        return map;
    }

    @DeleteMapping("/employee/{id}")
    public Map<String,Object> deleteEmployee(@PathVariable Long id){
        Map<String,Object> map = new HashMap<>();

        try{
            employeeService.deleteEmployee(id);
            map.put("status","success");

        }catch (Exception e){
            map.put("status", e.getMessage());
        }

        return map;
    }
}
