package com.example.demo.dao.employee;

import com.example.demo.entity.employee.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {


    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        Employee temp =  entityManager.merge(employee);
        return temp;
    }

    @Override
    public Employee findById(int id) {
        Employee temp = entityManager.find(Employee.class,id);
        return temp;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Employee temp = entityManager.find(Employee.class,id);

        entityManager.remove(temp);
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee" , Employee.class);

        return theQuery.getResultList();
    }
}
