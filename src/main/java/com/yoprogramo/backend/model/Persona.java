package com.yoprogramo.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nombreCompleto;
    
    @Column(name="about",length=2000)
    private String about;
    
    private String titulo;
    
    /*private String userImg;
    
    @Column(name="backImg", nullable=true)
    private String backImg;
    
    @Column(name="email", length=60, nullable=false, unique=true)
    private String email;*/

    public Persona() {
    }

    public Persona(long id, String nombreCompleto, String about, String titulo/*, String userImg, String backImg, String email*/) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.about = about;
        this.titulo = titulo;
        /*this.userImg = userImg;
        this.backImg = backImg;
        this.email = email;*/
    }
    
    
}
