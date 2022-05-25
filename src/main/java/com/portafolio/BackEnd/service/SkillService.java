/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portafolio.BackEnd.repository.SkillRepository;

/**
 *
 * @author Francisco
 */
@Service
public class SkillService implements ISkillService{
    @Autowired
    private SkillRepository skillsRepository;
    
    @Override
    public List<Skill> getSkills(){
        List<Skill> listaSkills = skillsRepository.findAll();
        return listaSkills;
    }
    @Override
    public void saveSkills (Skill skill){
        skillsRepository.save(skill);
    }
    
    @Override
    public void deleteSkills (Long id){
        skillsRepository.deleteById(id);
    }
    
    @Override
    public Skill findSkills (Long id){
        Skill skill = skillsRepository.findById(id).orElse(null);
        return skill;
    }
}
