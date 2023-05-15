package com.yoprogramo.backend.controller;

import com.yoprogramo.backend.model.Red;
import com.yoprogramo.backend.service.RedService;
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
@RequestMapping("/red/")
@CrossOrigin(origins = "https://portfolio-gao.web.app/")//http://localhost:4200/
public class RedController {
    
    @Autowired
    private RedService redService;
    
    //Listar Redes
    @GetMapping("list")
    public List<Red>getRedes(){
        return redService.getRedes();
    }
    
    //Agregar Red
    @PostMapping("save")
    public ResponseEntity saveRed(@RequestBody Red re){
        Red red=redService.saveRed(re);
        return ResponseEntity.ok(red);//"Los datos se registraron correctamente";
    }
    
    //Busca Red
    @GetMapping("{id}")
    public ResponseEntity<Red>getRedById(@PathVariable int id){
        Red red = redService.findRed(id);
        return ResponseEntity.ok(red);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<Red>updateRed(@PathVariable int id,@RequestBody Red re){
        Red red = redService.findRed(id);
        
        red.setName(re.getName());
        red.setUrl(re.getUrl());
        
        Red redActualizada = redService.updateRed(red);
        return ResponseEntity.ok(redActualizada);
        
    }
    
    @DeleteMapping("{id}")
    public void deleteRed(@PathVariable int id){
        redService.deleteRed(id);
        //return "Se eliminó exitosamente";
    }
}