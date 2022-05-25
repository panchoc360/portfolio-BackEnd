/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Proyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portafolio.BackEnd.repository.ProyectoRepository;

/**
 *
 * @author Francisco
 */
@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private ProyectoRepository proyRepository;
    
    @Override
    public List<Proyecto> getProyectos(){
        List<Proyecto> listaPersonas = proyRepository.findAll();
        return listaPersonas;
    }
    @Override
    public void saveProyectos (Proyecto proy){
        proyRepository.save(proy);
    }
    
    @Override
    public void deleteProyectos (Long id){
        proyRepository.deleteById(id);
    }
    
    @Override
    public Proyecto findProyectos (Long id){
        Proyecto proy = proyRepository.findById(id).orElse(null);
        return proy;
    }
}
