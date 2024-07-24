package com.vinitspring.fullstack_backend.controller;

import com.vinitspring.fullstack_backend.exception.EmployeeNotFoundException;
import com.vinitspring.fullstack_backend.model.Employee;
import com.vinitspring.fullstack_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //Update employee details
    @GetMapping("/employees/updaterecords/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}


