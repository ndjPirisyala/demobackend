package com.example.demobackend.service;

import com.example.demobackend.model.Employee;
import com.example.demobackend.model.Skill;
import com.example.demobackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee getEmployee(int id){
        return employeeRepository.findById(id).get();
    }

    public void addEmployee(String employeeName,String employeeDob, String employeeEmail, String givenSkillsIds, String givenSkillNames) throws RuntimeException{
        Employee employee = new Employee();
        employee.setName(employeeName);
        employee.setDob(employeeDob);
        employee.setEmail(employeeEmail);
        if(!givenSkillsIds.equals("noskill")){
            employee.setGivenSkills(convert(givenSkillsIds,givenSkillNames));
        }
        employeeRepository.save(employee);
    }

    public void updateEmployee(int employeeId, String employeeName,String employeeDob,String employeeEmail, String givenSkillsIds, String givenSkillNames) throws RuntimeException{
        Employee employee = employeeRepository.findById(employeeId).get();
        employee.setName(employeeName);
        employee.setDob(employeeDob);
        employee.setEmail(employeeEmail);
        if(!givenSkillsIds.equals("noskill")){
            employee.setGivenSkills(convert(givenSkillsIds,givenSkillNames));
        }
        else{
            employee.setGivenSkills(null);
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer employeeId) throws RuntimeException{
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public String getNextId(){
        List<Employee> list = getAllEmployee();
        List<Integer> maxList = new ArrayList<Integer>();
        for(int i=0; i<list.size(); i++){
            maxList.add(list.get(i).getId());
        }
        return Integer.toString(Collections.max(maxList)+50);
    }

    public Set<Skill> convert(String skillIds, String skillNames){
        Set<Skill> sSet = new HashSet<>();
        String[] arr = skillIds.split(",");
        Integer sIds[] = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            sIds[i] = Integer.valueOf(arr[i]);
        }
        String[] sNames = skillNames.split(",");

        for(int i=0;i<arr.length;i++){
            Skill s = new Skill();
            s.setSkillId(sIds[i]);
            s.setSkillName(sNames[i]);
            sSet.add(s);
        }
        return sSet;
    }

}
