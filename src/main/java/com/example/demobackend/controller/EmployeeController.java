package com.example.demobackend.controller;


import com.example.demobackend.exception.ResourceNotFoundException;
import com.example.demobackend.model.Employee;
import com.example.demobackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //GET-read
    @CrossOrigin
    @RequestMapping("/view-emp/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }

    //POST-insert
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/add-emp")
    public void addEmployee(@RequestParam(value="employeeName") String employeeName,
                            @RequestParam(value = "employeeDob") String employeeDob,
                            @RequestParam(value="employeeEmail") String employeeEmail){
        employeeService.addEmployee(employeeName,employeeDob,employeeEmail);
    }

    //PUT-update
    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/edit-emp")
    public void updateEmployee(@RequestParam(value="employeeId") int employeeId,
                               @RequestParam(value="employeeName") String employeeName,
                               @RequestParam(value = "employeeDob") String employeeDob,
                               @RequestParam(value="employeeEmail") String employeeEmail){
        employeeService.updateEmployee(employeeId,employeeName,employeeDob,employeeEmail);
    }

    //Delete
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete-emp/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @CrossOrigin
    @RequestMapping("/nextID")
    public void getNextId(){
        employeeService.getNextId();
    }


}
