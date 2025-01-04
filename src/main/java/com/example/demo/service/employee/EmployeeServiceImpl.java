package com.example.demo.service.employee;

import com.example.demo.dao.employee.EmployeeDAO;
import com.example.demo.dao.employee.EmployeeRepository;
import com.example.demo.entity.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

  /*  private EmployeeDAO employeeDAO;*/

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = new Employee();
        if(result.isPresent()){
            employee = result.get();
        }else {
            throw new RuntimeException("error not found");
        }
        return employee;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll()  ;
    }

    @Override
    public List<Employee> findAllByOrderByFirstNameAsc() {
        return employeeRepository.findAllByOrderByFirstNameAsc();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }


}
