package com.yoprogramo.backend.service;

import com.yoprogramo.backend.model.Red;
import com.yoprogramo.backend.repository.RedRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedService {
    
    @Autowired
    private RedRepository redRepository;
    
    public List<Red> getRedes() {
        List<Red> listaRedes = redRepository.findAll();
        return listaRedes;
    }

    public Red saveRed(Red re) {
        return redRepository.save(re);
    }
    
    public Red updateRed(Red re) {
        return redRepository.save(re);
    }

    public void deleteRed(int id) {
        redRepository.deleteById(id);
    }

    public Red findRed(int id) {
        //acá si no encuentro la persona, devuelvo null por eso va el orElse
        Red red = redRepository.findById(id).orElse(null);
        return red;
    }
}
