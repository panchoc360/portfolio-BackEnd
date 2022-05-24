/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Proyectos;
import com.portafolio.BackEnd.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco
 */
@Service
public class ProyectosService implements IProyectosService{
    
    @Autowired
    private ProyectosRepository proyRepository;
    
    @Override
    public List<Proyectos> getProyectos(){
        List<Proyectos> listaPersonas = proyRepository.findAll();
        return listaPersonas;
    }
    @Override
    public void saveProyectos (Proyectos proy){
        proyRepository.save(proy);
    }
    
    @Override
    public void deleteProyectos (Long id){
        proyRepository.deleteById(id);
    }
    
    @Override
    public Proyectos findProyectos (Long id){
        Proyectos proy = proyRepository.findById(id).orElse(null);
        return proy;
    }
}
