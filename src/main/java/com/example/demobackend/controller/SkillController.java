package com.example.demobackend.controller;

import com.example.demobackend.model.Skill;
import com.example.demobackend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @CrossOrigin
    @RequestMapping("view-skill/{id}")
    public Skill getSkill(@PathVariable Integer id){
        return skillService.getSkill(id);
    }

    @CrossOrigin
    @RequestMapping("/view-all-skills")
    public List<Skill> getAllSkills(){
        return skillService.getAllSkills();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/add-skill")
    public void addSkill(@RequestParam(value="skillName") String skillName){
        skillService.addSkill(skillName);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/edit-skill")
    public void updateSkill(@RequestParam(value="skillId") int skillId,
                            @RequestParam(value="skillName") String skillName){
        skillService.updateSkill(skillId,skillName);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete-skill/{skillId}")
    public void deleteSkill(@PathVariable Integer skillId){
        skillService.deleteSkill(skillId);
    }

    @CrossOrigin
    @RequestMapping("/nextSkillID")
    public String getNextId(){
        return skillService.getNextId();
    }

}
