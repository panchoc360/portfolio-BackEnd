/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Proyecto;
import java.util.List;

/**
 *
 * @author Francisco
 */
public interface IProyectoService {
        public List<Proyecto> getProyectos();
    
    public void saveProyectos (Proyecto proy);
    
    public void deleteProyectos (Long id);
    
    public Proyecto findProyectos (Long id);
}
