/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author Francisco
 */
@Entity
@Getter @Setter
@DynamicUpdate
public class Experiencia  implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idExperiencia;
    
    private String nombreLugar;
    private String cargoOcupado;
    private int inicio;
    private int fin;
    private String descripcion;
    @Column(name = "urlLogo")
    private String urlLogo;
    private String urlWebPage;

    public Experiencia() {
    }

    public Experiencia(Long idExperiencia, String nombreLugar, String cargoOcupado, int inicio, int fin, String descripcion, String urlLogo, String urlWebPage) {
        this.idExperiencia = idExperiencia;
        this.nombreLugar = nombreLugar;
        this.cargoOcupado = cargoOcupado;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
        this.urlWebPage = urlWebPage;
    }


    
    
}
