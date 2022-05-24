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
public class Educacion  implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEducacion;
    
    private String nombreInstitucion;
    private String titulo;
    private int inicio;
    private int fin;
    private String urlImagen;

    public Educacion() {
    }

    public Educacion(Long idEducacion, String nombreInstitucion, String titulo, int inicio, int fin, String urlImagen) {
        this.idEducacion = idEducacion;
        this.nombreInstitucion = nombreInstitucion;
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.urlImagen = urlImagen;
    }
    
    
}
