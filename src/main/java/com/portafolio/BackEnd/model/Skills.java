/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Francisco
 */
@Entity
@Getter @Setter
public class Skills  implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idSkill;
    
    private String skill;
    private int nivel;

    public Skills() {
    }

    public Skills(Long idSkill, String skill, int nivel) {
        this.idSkill = idSkill;
        this.skill = skill;
        this.nivel = nivel;
    }
    
    
}
