package com.example.demobackend.service;

import com.example.demobackend.model.Employee;
import com.example.demobackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee getEmployee(int id){
        return employeeRepository.findById(id).get();
    }

    public void addEmployee(String employeeName,String employeeDob, String employeeEmail) throws RuntimeException{
        Employee employee = new Employee();
        employee.setName(employeeName);
        employee.setDob(employeeDob);
        employee.setEmail(employeeEmail);
        employeeRepository.save(employee);
    }

    public void updateEmployee(int employeeId, String employeeName,String employeeDob,String employeeEmail) throws RuntimeException{
        Employee employee = employeeRepository.findById(employeeId).get();
        employee.setName(employeeName);
        employee.setDob(employeeDob);
        employee.setEmail(employeeEmail);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer employeeId) throws RuntimeException{
        employeeRepository.deleteById(employeeId);
    }

    public String getNextId(){
        return employeeRepository.getNextSeriesId().toString();
    }
}
