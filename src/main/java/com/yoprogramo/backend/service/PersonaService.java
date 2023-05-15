package com.yoprogramo.backend.service;

import com.yoprogramo.backend.model.Persona;
import com.yoprogramo.backend.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepository persoRepository;
    
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persoRepository.findAll();
        return listaPersonas;
    }

    public void savePersona(Persona perso) {
        persoRepository.save(perso);
    }
    
    public Persona updatePersona(Persona perso) {
        return persoRepository.save(perso);
    }

    public void deletePersona(Long id) {
        persoRepository.deleteById(id);
    }

    public Persona findPersona(Long id) {
        //acá si no encuentro la persona, devuelvo null por eso va el orElse
        Persona perso = persoRepository.findById(id).orElse(null);
        return perso;
    }
}
