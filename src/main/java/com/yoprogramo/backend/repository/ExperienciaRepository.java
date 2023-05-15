package com.yoprogramo.backend.repository;

import com.yoprogramo.backend.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//mapeamos como repositorio
//la interface extiende de JpaRepository (que maneja repositorios JPA)
//en los parametros <> debe ir:<clase a persistir, tipo de dato de su ID>
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    
}
