/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Experiencia;
import com.portafolio.BackEnd.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco
 */
@Service
public class ExperienciaService implements IExperienciaService{
    
    
    @Autowired
    private ExperienciaRepository ExpRepository;
    
    @Override
    public List<Experiencia> getExperiencia(){
        List<Experiencia> listaExperiencia = ExpRepository.findAll();
        return listaExperiencia;
    }
    @Override
    public void saveExperiencia (Experiencia exp){
        ExpRepository.save(exp);
    }
    
    @Override
    public void deleteExperiencia (Long id){
        ExpRepository.deleteById(id);
    }
    
    @Override
    public Experiencia findExperiencia (Long id){
        Experiencia edu = ExpRepository.findById(id).orElse(null);
        return edu;
    }
}
