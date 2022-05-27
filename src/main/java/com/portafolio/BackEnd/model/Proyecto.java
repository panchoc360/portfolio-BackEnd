/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.model;

import java.io.Serializable;
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
public class Proyecto  implements Serializable{
        @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idProyecto;
    
    private String Nombre;
    private int fecha;
    private String descripcion;
    private String url;
    private String urlImagen;

    public Proyecto() {
    }

    public Proyecto(Long idProyecto, String Nombre, int fecha, String descripcion, String url, String urlImagen) {
        this.idProyecto = idProyecto;
        this.Nombre = Nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.url = url;
        this.urlImagen = urlImagen;
    }
    
    
    
}
