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

    //Update Employee details by ID
    @PutMapping("/employees/updaterecords/{id}")
    Employee updateEmployeeDetails(@RequestBody Employee currEmp,@PathVariable Long id){
        return employeeRepository.findById(id)
                .map(employee -> {
//                    employee.setFullName(currEmp.getFullName());
                    employee.setEmail(currEmp.getEmail());
                    employee.setPosition(currEmp.getPosition());
                    return employeeRepository.save(employee);
                }).orElseThrow(()-> new EmployeeNotFoundException(id));
    }

    //Delete an employee records
    @DeleteMapping("/employee/delete/{id}")
    String deleteEmployee(@PathVariable Long id){
        if(!employeeRepository.existsById(id)){
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        return "Employee records deleted Successfully";
    }

    //Retrieve employee details by ID
    @GetMapping("/employees/single/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}


