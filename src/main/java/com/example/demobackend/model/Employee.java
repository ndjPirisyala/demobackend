package com.example.demobackend.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")

    @SequenceGenerator(
            name = "employee_generator",
            sequenceName = "employee_sequence",
            initialValue = 1,
            allocationSize=1
    )

    private Integer employeeId;

    @NotBlank
    @Size(max = 60)
    private String employeeName;

    @NotBlank
    private String employeeDob;

    @NotBlank
    @Size(max=100)
    private String employeeEmail;

    @ManyToMany
    @JoinTable(
            name = "skills_having",
            joinColumns = @JoinColumn(name = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "skillId"))
    Set<Skill> givenSkills;

    // Getters and Setters
    public Integer getId() {
        return employeeId;
    }

    public void setId(Integer id) {
        this.employeeId = id;
    }

    public String getName() {
        return employeeName;
    }

    public void setName(String name) {
        this.employeeName = name;
    }

    public String getDob() {
        return employeeDob;
    }

    public void setDob(String employeeDob) {
        this.employeeDob = employeeDob;
    }

    public String getEmail() {
        return employeeEmail;
    }

    public void setEmail(String email) {
        this.employeeEmail = email;
    }

    public Set<Skill> getGivenSkills() {
        return givenSkills;
    }

    public void setGivenSkills(Set<Skill> givenSkills) {
        this.givenSkills = givenSkills;
    }

}
