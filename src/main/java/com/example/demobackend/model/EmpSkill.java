package com.example.demobackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "skills")
public class EmpSkill extends AuditModel{

    @Id
    @GeneratedValue(generator = "skill_generator")
    @SequenceGenerator(
            name = "skill_generator",
            sequenceName = "skill_sequence",
            initialValue = 1
    )
    private Long id;

    @NotBlank
    @Size(max=50)
    private String skillName;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employeeID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employee employee;


    //getters and setters
    public Long getId() {
        return id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
