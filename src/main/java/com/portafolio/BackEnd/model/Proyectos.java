/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.model;

import java.util.Date;
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
public class Proyectos {
        @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idProyecto;
    
    private String Nombre;
    private Date fecha;
    private String descripcion;
    private String url;
    private String urlImagen;

    public Proyectos() {
    }

    public Proyectos(Long idProyecto, String Nombre, Date fecha, String descripcion, String url, String urlImagen) {
        this.idProyecto = idProyecto;
        this.Nombre = Nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.url = url;
        this.urlImagen = urlImagen;
    }
    
    
    
}