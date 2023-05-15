package com.yoprogramo.backend.controller;

import com.yoprogramo.backend.model.Proyecto;
import com.yoprogramo.backend.service.ProyectoService;
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
@RequestMapping("/project/")
@CrossOrigin(origins = "https://portfolio-gao.web.app/")//http://localhost:4200/
public class ProyectoController {
    
    @Autowired
    private ProyectoService proyeService;
    
    //Listar Proyectos
    @GetMapping("list")
    public List<Proyecto>getProyectos(){
        return proyeService.getProyectos();
    }
    
    //Agregar Proyecto
    @PostMapping("save")
    public ResponseEntity saveProyecto(@RequestBody Proyecto proye){
        Proyecto proyecto=proyeService.saveProyecto(proye);
        return ResponseEntity.ok(proyecto);//"Los datos se registraron correctamente";
    }
    
    //Busca Proyecto
    @GetMapping("{id}")
    public ResponseEntity<Proyecto>getProyectoById(@PathVariable int id){
        Proyecto proyecto = proyeService.findProyecto(id);
        return ResponseEntity.ok(proyecto);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<Proyecto>updateProyecto(@PathVariable int id,@RequestBody Proyecto proye){
        Proyecto proyecto = proyeService.findProyecto(id);
        
        proyecto.setName(proye.getName());
        //proyecto.setImg(proye.getImg());
        proyecto.setDescription(proye.getDescription());
        proyecto.setUrl(proye.getUrl());
        
        Proyecto proyectoActualizado = proyeService.updateProyecto(proyecto);
        return ResponseEntity.ok(proyectoActualizado);
        
    }
    
    @DeleteMapping("{id}")
    public void deleteProyecto(@PathVariable int id){
        proyeService.deleteProyecto(id);
        //return "Se eliminó exitosamente";
    }
}