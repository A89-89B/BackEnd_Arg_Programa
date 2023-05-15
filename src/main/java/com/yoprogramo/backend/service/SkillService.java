package com.yoprogramo.backend.service;

import com.yoprogramo.backend.model.Skill;
import com.yoprogramo.backend.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    
    @Autowired
    private SkillRepository skillRepository;
    
    public List<Skill> getSkills() {
        List<Skill> listaSkills = skillRepository.findAll();
        return listaSkills;
    }

    public Skill saveSkill(Skill ski) {
        return skillRepository.save(ski);
    }
    
    public Skill updateSkill(Skill ski) {
        return skillRepository.save(ski);
    }

    public void deleteSkill(int id) {
        skillRepository.deleteById(id);
    }

    public Skill findSkill(int id) {
        //acá si no encuentro la persona, devuelvo null por eso va el orElse
        Skill skill = skillRepository.findById(id).orElse(null);
        return skill;
    }
}
