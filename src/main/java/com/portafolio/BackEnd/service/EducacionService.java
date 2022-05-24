/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Francisco
 */
public class EducacionService implements IEducacionService{
    
        
    @Autowired
    private EducacionRepository persoRepository;
    
    @Override
    public List<Persona> getEducacion(){
        List<Persona> listaPersonas = persoRepository.findAll();
        return listaPersonas;
    }
    @Override
    public void saveEducacion (Educacion edu){
        persoRepository.save(edu);
    }
    
    @Override
    public void deleteEducacion (Long id){
        persoRepository.deleteById(id);
    }
    
    @Override
    public Persona findEducacion (Long id){
        Persona perso = persoRepository.findById(id).orElse(null);
        return perso;
    }
}
