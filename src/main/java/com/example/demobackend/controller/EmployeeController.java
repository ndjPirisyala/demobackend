package com.example.demobackend.controller;

import com.example.demobackend.exception.ResourceNotFoundException;
import com.example.demobackend.model.Employee;
import com.example.demobackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


}
