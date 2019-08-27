package com.example.demobackend.service;

import com.example.demobackend.model.Skill;
import com.example.demobackend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill getSkill(int id) {
        return skillRepository.findById(id).get();
    }

    public List<Skill> getAllSkills(){
        return skillRepository.findAll();
    }

    public void addSkill(String skillName) throws RuntimeException{
        Skill skill = new Skill();
        skill.setSkillName(skillName);
        skillRepository.save(skill);
    }

    public void updateSkill(Integer skillId,String skillName){
        Skill skill = skillRepository.findById(skillId).get();
        skill.setSkillName(skillName);
        skillRepository.save(skill);
    }

    public void deleteSkill(Integer skillId){
        skillRepository.deleteById(skillId);
    }

    public String getNextId(){
        return skillRepository.getNextSeriesId().toString();
    }
}
