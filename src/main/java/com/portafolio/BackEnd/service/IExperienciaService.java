/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Experiencia;
import java.util.List;

/**
 *
 * @author Francisco
 */
public interface IExperienciaService {
    
        
    public List<Experiencia> getExperiencia();
    
    public void saveExperiencia (Experiencia exp);
    
    public void deleteExperiencia (Long id);
    
    public Experiencia findExperiencia (Long id);
}

