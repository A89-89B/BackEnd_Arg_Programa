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
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String company;
    private String position;
    //@Column(name="img",nullable=true)
    //private String img;
    @Column(name="description",length=1000, nullable=true)
    private String description;
    @Column(name="start", length=4, nullable=false)
    private int start;
    private String end;

    public Experiencia() {
    }

    public Experiencia(int id, String company, String position, String description, int start, String end) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.description = description;
        this.start = start;
        this.end = end;
    }
    
    
}
