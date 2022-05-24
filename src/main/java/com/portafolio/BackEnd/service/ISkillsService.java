/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Skills;
import java.util.List;

/**
 *
 * @author Francisco
 */
public interface ISkillsService {
    public List<Skills> getSkills();
    
    public void saveSkills (Skills perso);
    
    public void deleteSkills (Long id);
    
    public Skills findSkills (Long id);
}
