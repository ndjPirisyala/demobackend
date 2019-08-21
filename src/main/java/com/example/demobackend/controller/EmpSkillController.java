package com.example.demobackend.controller;

import com.example.demobackend.exception.ResourceNotFoundException;
import com.example.demobackend.model.EmpSkill;
import com.example.demobackend.repository.EmployeeRepository;
import com.example.demobackend.repository.EmpSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

public class EmpSkillController {

    @Autowired
    private EmpSkillRepository empSkillRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
}
