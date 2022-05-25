/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Skill;
import java.util.List;

/**
 *
 * @author Francisco
 */
public interface ISkillService {
    public List<Skill> getSkills();
    
    public void saveSkills (Skill perso);
    
    public void deleteSkills (Long id);
    
    public Skill findSkills (Long id);
}
