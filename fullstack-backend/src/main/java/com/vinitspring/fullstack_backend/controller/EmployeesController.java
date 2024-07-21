package com.vinitspring.fullstack_backend.controller;

import com.vinitspring.fullstack_backend.model.Employee;
import com.vinitspring.fullstack_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class EmployeesController {

    @Autowired  //automatic dependency injection
    private EmployeeRepository employeeRepository;

    @PostMapping ("/employee")   //add a new employee
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/getemployees")    //retrieve details of all employees
    List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}


