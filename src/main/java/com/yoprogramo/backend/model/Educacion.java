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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String institution;
    private String nameCurso;
    //@Column(name="img",nullable=true)
    //private String img;
    @Column(name="start", length=4, nullable=false)
    private int start;
    private String end;

    public Educacion() {
    }

    public Educacion(int id, String institution, String nameCurso, int start, String end) {
        this.id = id;
        this.institution = institution;
        this.nameCurso = nameCurso;
        this.start = start;
        this.end = end;
    }
    
    
}
