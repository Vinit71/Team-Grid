package com.vinitspring.fullstack_backend.repository;
import com.vinitspring.fullstack_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;   //responsible for db communication

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
