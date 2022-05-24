/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Skills;
import com.portafolio.BackEnd.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco
 */
@Service
public class SkillsService implements ISkillsService{
    @Autowired
    private SkillsRepository skillsRepository;
    
    @Override
    public List<Skills> getSkills(){
        List<Skills> listaSkills = skillsRepository.findAll();
        return listaSkills;
    }
    @Override
    public void saveSkills (Skills skill){
        skillsRepository.save(skill);
    }
    
    @Override
    public void deleteSkills (Long id){
        skillsRepository.deleteById(id);
    }
    
    @Override
    public Skills findSkills (Long id){
        Skills skill = skillsRepository.findById(id).orElse(null);
        return skill;
    }
}
