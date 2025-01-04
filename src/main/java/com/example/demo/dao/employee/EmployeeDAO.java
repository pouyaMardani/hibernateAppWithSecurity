package com.example.demo.dao.employee;

import com.example.demo.entity.employee.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee save(Employee employee);

    Employee findById(int id);

    void deleteById(int id);

    List<Employee> findAll();

}
