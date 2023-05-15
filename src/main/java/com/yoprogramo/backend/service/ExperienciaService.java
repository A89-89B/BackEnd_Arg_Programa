package com.yoprogramo.backend.service;

import com.yoprogramo.backend.model.Experiencia;
import com.yoprogramo.backend.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {
    
    @Autowired
    private ExperienciaRepository expRepository;
    
    public List<Experiencia> getExperiencias() {
        List<Experiencia> listaExperiencias = expRepository.findAll();
        return listaExperiencias;
    }

    public Experiencia saveExperiencia(Experiencia exp) {
        return expRepository.save(exp);
    }
    
    public Experiencia updateExperiencia(Experiencia exp) {
        return expRepository.save(exp);
    }

    public void deleteExperiencia(int id) {
        expRepository.deleteById(id);
    }

    public Experiencia findExperiencia(int id) {
        //acá si no encuentro la persona, devuelvo null por eso va el orElse
        Experiencia exp = expRepository.findById(id).orElse(null);
        return exp;
    }
}
