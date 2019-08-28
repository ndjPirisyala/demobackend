package com.example.demobackend.service;

import com.example.demobackend.model.Employee;
import com.example.demobackend.model.Skill;
import com.example.demobackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

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
        employee.setGivenSkills(convert(givenSkillsIds,givenSkillNames));
        employeeRepository.save(employee);
    }

    public void updateEmployee(int employeeId, String employeeName,String employeeDob,String employeeEmail, String givenSkillsIds, String givenSkillNames) throws RuntimeException{
        Employee employee = employeeRepository.findById(employeeId).get();
        employee.setName(employeeName);
        employee.setDob(employeeDob);
        employee.setEmail(employeeEmail);
        employee.setGivenSkills(convert(givenSkillsIds,givenSkillNames));
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer employeeId) throws RuntimeException{
        employeeRepository.deleteById(employeeId);
    }

    public String getNextId(){
        return employeeRepository.getNextSeriesId().toString();
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
