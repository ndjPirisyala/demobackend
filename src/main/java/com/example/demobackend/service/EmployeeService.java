package com.example.demobackend.service;

import com.example.demobackend.model.Employee;
import com.example.demobackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployee(Integer id){
        return employeeRepository.getOne(id);
    }

    public void addEmployee(Employee emp){
        employeeRepository.save(emp);
    }

    public void updateEmployee(Employee emp){
        employeeRepository.save(emp);
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }
}
