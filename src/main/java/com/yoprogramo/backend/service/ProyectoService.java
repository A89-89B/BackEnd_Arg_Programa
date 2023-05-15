package com.yoprogramo.backend.service;

import com.yoprogramo.backend.model.Proyecto;
import com.yoprogramo.backend.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService {
    
    @Autowired
    private ProyectoRepository proyeRepository;
    
    public List<Proyecto> getProyectos() {
        List<Proyecto> listaProyectos = proyeRepository.findAll();
        return listaProyectos;
    }

    public Proyecto saveProyecto(Proyecto proye) {
        return proyeRepository.save(proye);
    }
    
    public Proyecto updateProyecto(Proyecto proye) {
        return proyeRepository.save(proye);
    }

    public void deleteProyecto(int id) {
        proyeRepository.deleteById(id);
    }

    public Proyecto findProyecto(int id) {
        //acá si no encuentro la persona, devuelvo null por eso va el orElse
        Proyecto proye = proyeRepository.findById(id).orElse(null);
        return proye;
    }
}
