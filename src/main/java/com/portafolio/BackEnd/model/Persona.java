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
@Getter @Setter
@Entity
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPersona;

    private String nombre;
    private String email;
    private String telefono;
    private String acercade;
    private String urlImagenPerfil;
    private String urlImagenPortada;
    
    
    public Persona(Long idPersona, String nombre, String email, String telefono, String acercade, String urlimagenPerfil, String urlImagenPortada) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.acercade = acercade;
        this.urlImagenPerfil = urlimagenPerfil;
        this.urlImagenPortada = urlImagenPortada;
    }
    
    public Persona() {
    }
}
