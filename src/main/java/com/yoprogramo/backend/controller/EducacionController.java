package com.yoprogramo.backend.controller;

import com.yoprogramo.backend.model.Educacion;
import com.yoprogramo.backend.service.EducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/education/")
@CrossOrigin(origins = "https://portfolio-gao.web.app/")//http://localhost:4200/
public class EducacionController {
    
    @Autowired
    private EducacionService eduService;
    
    //Listar Educaciones
    @GetMapping("list")
    public List<Educacion>getEducaciones(){
        return eduService.getEducaciones();
    }
    
    //Agregar Educación
    @PreAuthorize("hasRole('USER')")//como todas las cuentas serán user no tiene mucho sentido su uso ahora
    @PostMapping("save")
    public ResponseEntity saveEducacion(@RequestBody Educacion edu){
        Educacion educacion=eduService.saveEducacion(edu);
        return ResponseEntity.ok(educacion);//"Los datos se registraron correctamente";
    }
    
    //Busca Educación
    @GetMapping("{id}")
    public ResponseEntity<Educacion>getEducacionById(@PathVariable int id){
        Educacion educacion = eduService.findEducacion(id);
        //              .orElseThrow(() -> new RunTimeException(message));  no funciona
        return ResponseEntity.ok(educacion);
    }
    
    @PreAuthorize("hasRole('USER')")
    @PutMapping("update/{id}")
    public ResponseEntity<Educacion>updateEducacion(@PathVariable int id,@RequestBody Educacion edu){
        Educacion educacion = eduService.findEducacion(id);
        
        educacion.setInstitution(edu.getInstitution());
        educacion.setNameCurso(edu.getNameCurso());
        //educacion.setImg(edu.getImg());
        educacion.setStart(edu.getStart());
        educacion.setEnd(edu.getEnd());
        
        Educacion educacionActualizada = eduService.updateEducacion(educacion);
        return ResponseEntity.ok(educacionActualizada);
        
    }
    
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("{id}")
    public void deleteEducacion(@PathVariable int id){
        eduService.deleteEducacion(id);
        //return "Se eliminó exitosamente";
    }
}
