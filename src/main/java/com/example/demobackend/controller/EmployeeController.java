package com.example.demobackend.controller;

import com.example.demobackend.exception.ResourceNotFoundException;
import com.example.demobackend.model.Employee;
import com.example.demobackend.repository.EmployeeRepository;
import com.example.demobackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/view-emp/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-emp")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/edit-emp")
    public void updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
    }

    public void deleteEmployee(Integer id){
        employeeService.deleteEmployee(id);
    }


}
