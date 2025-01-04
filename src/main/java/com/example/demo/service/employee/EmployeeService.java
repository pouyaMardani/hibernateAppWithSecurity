package com.example.demo.service.employee;

import com.example.demo.entity.employee.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee findById(int id);

    void deleteById(int id);

    List<Employee> findAll();


    List<Employee> findAllByOrderByFirstNameAsc();
}
