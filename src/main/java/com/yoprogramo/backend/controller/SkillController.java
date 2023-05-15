package com.yoprogramo.backend.controller;

import com.yoprogramo.backend.model.Skill;
import com.yoprogramo.backend.service.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill/")
@CrossOrigin(origins = "http://localhost:4200/")
public class SkillController {
    
    @Autowired
    private SkillService skillService;
    
    //Listar Skills
    @GetMapping("list")
    public List<Skill>getSkills(){
        return skillService.getSkills();
    }
    
    //Agregar Skill
    @PostMapping("save")
    public ResponseEntity saveSkill(@RequestBody Skill ski){
        Skill skill=skillService.saveSkill(ski);
        return ResponseEntity.ok(skill);//"Los datos se registraron correctamente";
    }
    
    //Busca Skill
    @GetMapping("{id}")
    public ResponseEntity<Skill>getSkillById(@PathVariable int id){
        Skill skill = skillService.findSkill(id);
        return ResponseEntity.ok(skill);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<Skill>updateSkill(@PathVariable int id,@RequestBody Skill ski){
        Skill skill = skillService.findSkill(id);
        
        skill.setType(ski.getType());
        skill.setName(ski.getName());
        skill.setProgress(ski.getProgress());
        
        Skill skillActualizada = skillService.updateSkill(skill);
        return ResponseEntity.ok(skillActualizada);
        
    }
    
    @DeleteMapping("{id}")
    public void deleteSkill(@PathVariable int id){
        skillService.deleteSkill(id);
        //return "Se eliminó exitosamente";
    }
}