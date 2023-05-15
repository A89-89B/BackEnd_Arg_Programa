package com.yoprogramo.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String name;
    private int progress;

    public Skill() {
    }

    public Skill(int id, String name, int progress) {
        this.id = id;
        this.name = name;
        this.progress = progress;
    }
    
    
}
