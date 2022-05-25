/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.model;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Francisco
 */
@Getter  @Setter
public class PortfolioDTO implements Serializable{
    

    private List<Persona> persona;
    private List<Educacion> educacion;
    private List<Experiencia> experiencia;
    private List<Proyecto> proyecto;
    private List<Skill> skill;

    public PortfolioDTO(List<Persona> per, List<Educacion> edu, List<Experiencia> exp, List<Proyecto> pry, List<Skill> skl) {
        this.persona = per;
        this.educacion = edu;
        this.experiencia = exp;
        this.proyecto = pry;
        this.skill = skl;
    }
    
        public PortfolioDTO() {
    }
    
}

