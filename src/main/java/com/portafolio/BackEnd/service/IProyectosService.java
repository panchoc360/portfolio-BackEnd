/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Proyectos;
import java.util.List;

/**
 *
 * @author Francisco
 */
public interface IProyectosService {
        public List<Proyectos> getProyectos();
    
    public void saveProyectos (Proyectos proy);
    
    public void deleteProyectos (Long id);
    
    public Proyectos findProyectos (Long id);
}
