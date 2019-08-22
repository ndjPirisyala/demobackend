package com.example.demobackend.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
@Table(name = "employee")
public class Employee extends AuditModel{
    @Id
    @GeneratedValue(generator = "employee_generator")

    @SequenceGenerator(
            name = "employee_generator",
            sequenceName = "employee_sequence",
            initialValue = 1
    )

    private Integer empId;

    @NotBlank
    @Size(max = 60)
    private String empName;

    @NotBlank
    @Size(max=100)
    private String empEmail;

    private ArrayList<String> skills;


    // Getters and Setters
    public Integer getId() {
        return empId;
    }

    public void setId(Integer id) {
        this.empId = id;
    }

    public String getName() {
        return empName;
    }

    public void setName(String name) {
        this.empName = name;
    }

    public String getEmail() {
        return empEmail;
    }

    public void setEmail(String email) {
        this.empEmail = email;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
}
