package com.yoprogramo.backend.service;

import com.yoprogramo.backend.model.Educacion;
import com.yoprogramo.backend.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService {
    
    @Autowired
    private EducacionRepository eduRepository;
    
    public List<Educacion> getEducaciones() {
        List<Educacion> listaEducaciones = eduRepository.findAll();
        return listaEducaciones;
    }

    public Educacion saveEducacion(Educacion edu) {
        return eduRepository.save(edu);
    }
    
    public Educacion updateEducacion(Educacion edu) {
        return eduRepository.save(edu);
    }

    public void deleteEducacion(int id) {
        eduRepository.deleteById(id);
    }

    public Educacion findEducacion(int id) {
        //acá si no encuentro la persona, devuelvo null por eso va el orElse
        Educacion edu = eduRepository.findById(id).orElse(null);
        return edu;
    }
}
