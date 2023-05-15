package com.yoprogramo.backend.controller;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
import com.yoprogramo.backend.model.Persona;
import com.yoprogramo.backend.service.PersonaService;
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
@RequestMapping("/profile/")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaController {
    
    @Autowired
    private PersonaService persoService;
    
    //Listar personas
    @GetMapping("list")
    public List<Persona>getPersonas(){
        return persoService.getPersonas();
    }
    
    //Agregar Persona
    @PostMapping("save")
    public String savePersona(@RequestBody Persona perso){
        persoService.savePersona(perso);
        return "Los datos se registraron correctamente";
    }
    
    //Busca Persona
    @GetMapping("{id}")
    public ResponseEntity<Persona>getPersonaById(@PathVariable Long id){
        Persona persona = persoService.findPersona(id);
        //              .orElseThrow(() -> new RunTimeException(message));  no funciona
        return ResponseEntity.ok(persona);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<Persona>updatePersona(@PathVariable Long id,@RequestBody Persona perso){
        Persona persona = persoService.findPersona(id);
        
        persona.setNombreCompleto(perso.getNombreCompleto());
        persona.setAbout(perso.getAbout());
        persona.setTitulo(perso.getTitulo());
        /*persona.setUserImg(perso.getUserImg());
        persona.setBackImg(perso.getBackImg());
        persona.setEmail(perso.getEmail());*/
        
        Persona personaActualizada = persoService.updatePersona(persona);
        return ResponseEntity.ok(personaActualizada);
        
    }
    
    @DeleteMapping("{id}")
    public String deletePersona(@PathVariable Long id){
        persoService.deletePersona(id);
        return "Se eliminó exitosamente";
    }
}
