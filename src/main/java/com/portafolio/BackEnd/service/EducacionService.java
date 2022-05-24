/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Educacion;
import com.portafolio.BackEnd.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco
 */
@Service
public class EducacionService implements IEducacionService{
    
        
    @Autowired
    private EducacionRepository EduRepository;
    
    @Override
    public List<Educacion> getEducacion(){
        List<Educacion> listaEducacion = EduRepository.findAll();
        return listaEducacion;
    }
    @Override
    public void saveEducacion (Educacion edu){
        EduRepository.save(edu);
    }
    
    @Override
    public void deleteEducacion (Long id){
        EduRepository.deleteById(id);
    }
    
    @Override
    public Educacion findEducacion (Long id){
        Educacion edu = EduRepository.findById(id).orElse(null);
        return edu;
    }
}
