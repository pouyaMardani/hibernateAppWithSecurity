package com.example.demo.dao.employee;

import com.example.demo.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public List<Employee> findAllByOrderByFirstNameAsc();


}
