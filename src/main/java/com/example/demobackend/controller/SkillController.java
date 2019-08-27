package com.example.demobackend.controller;

import com.example.demobackend.model.Skill;
import com.example.demobackend.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public void getNextId(){
        skillService.getNextId();
    }

}
