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
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    /*@Column(name="img", nullable=true)
    private String img;*/
    private String description;
    private String url;

    public Proyecto() {
    }

    public Proyecto(int id, String name,/* String img,*/ String description, String url) {
        this.id = id;
        this.name = name;
        //this.img = img;
        this.description = description;
        this.url = url;
    }
    
    
}
