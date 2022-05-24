/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Educacion;
import java.util.List;

/**
 *
 * @author Francisco
 */
public interface IEducacionService {
    
    public List<Educacion> getEducacion();
    
    public void saveEducacion (Educacion perso);
    
    public void deleteEducacion (Long id);
    
    public Educacion findEducacion (Long id);
}

