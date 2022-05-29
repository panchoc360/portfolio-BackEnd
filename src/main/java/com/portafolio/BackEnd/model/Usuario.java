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
public class Usuario implements Serializable{
    @Id
    private String email;
    
    private String contra;
    private String token;

    public Usuario() {
    }

    public Usuario(String email, String contra, String token) {
        this.email = email;
        this.contra = contra;
        this.token = token;
    }
    
    
}
