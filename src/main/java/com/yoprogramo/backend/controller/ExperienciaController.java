package com.yoprogramo.backend.controller;

import com.yoprogramo.backend.model.Experiencia;
import com.yoprogramo.backend.service.ExperienciaService;
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
@RequestMapping("/experience/")
@CrossOrigin(origins = "https://portfolio-gao.web.app/")//http://localhost:4200/
public class ExperienciaController {
    
    @Autowired
    private ExperienciaService expService;
    
    //Listar Experiencias
    @GetMapping("list")
    public List<Experiencia>getExperiencias(){
        return expService.getExperiencias();
    }
    
    //Agregar Experiencia
    @PostMapping("save")
    public ResponseEntity saveExperiencia(@RequestBody Experiencia exp){
        Experiencia experiencia=expService.saveExperiencia(exp);
        return ResponseEntity.ok(experiencia);//"Los datos se registraron correctamente";
    }
    
    //Busca Experiencia
    @GetMapping("{id}")
    public ResponseEntity<Experiencia>getExperienciaById(@PathVariable int id){
        Experiencia experiencia = expService.findExperiencia(id);
        return ResponseEntity.ok(experiencia);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<Experiencia>updateExperiencia(@PathVariable int id,@RequestBody Experiencia exp){
        Experiencia experiencia = expService.findExperiencia(id);
        
        experiencia.setCompany(exp.getCompany());
        experiencia.setPosition(exp.getPosition());
        //experiencia.setImg(exp.getImg());
        experiencia.setDescription(exp.getDescription());
        experiencia.setStart(exp.getStart());
        experiencia.setEnd(exp.getEnd());
        
        Experiencia experienciaActualizada = expService.updateExperiencia(experiencia);
        return ResponseEntity.ok(experienciaActualizada);
        
    }
    
    @DeleteMapping("{id}")
    public void deleteExperiencia(@PathVariable int id){
        expService.deleteExperiencia(id);
        //return "Se eliminó exitosamente";
    }
}
