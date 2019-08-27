package com.example.demobackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "skill")
public class Skill extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_generator")

    @SequenceGenerator(
            name = "skill_generator",
            sequenceName = "skill_sequence",
            initialValue = 1,
            allocationSize=1
    )

    private Integer skillId;

    @NotBlank
    @Size(max = 60)
    private String skillName;

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

}
