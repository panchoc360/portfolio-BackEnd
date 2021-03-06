/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.controller;

import com.portafolio.BackEnd.model.Educacion;
import com.portafolio.BackEnd.model.Experiencia;
import com.portafolio.BackEnd.model.Persona;
import com.portafolio.BackEnd.model.PortfolioDTO;
import com.portafolio.BackEnd.model.Proyecto;
import com.portafolio.BackEnd.model.Skill;
import com.portafolio.BackEnd.service.EducacionService;
import com.portafolio.BackEnd.service.ExperienciaService;
import com.portafolio.BackEnd.service.PersonaService;
import com.portafolio.BackEnd.service.ProyectoService;
import com.portafolio.BackEnd.service.SkillService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Francisco
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "https://portfolio-frontend-c8e8e.web.app/"})
public class Controller {
    
    @Autowired
    private PersonaService interPersona;
    @Autowired
    private EducacionService interEducacion;
    @Autowired
    private ExperienciaService interExperiencia;
    @Autowired
    private ProyectoService interProyectos;
    @Autowired
    private SkillService interSkills;

    
    @GetMapping("/obtener/portfolio")
    public PortfolioDTO getPortfolio(){
        
        return new PortfolioDTO(interPersona.getPrimerPersona(),
                interEducacion.getEducacion(),
                interExperiencia.getExperiencia(),
                interProyectos.getProyectos(),
                interSkills.getSkills());
    }
   
    

    @GetMapping("/obtener/persona")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }
    
    @PostMapping ("/crear/persona")
    public String crearPersona(@RequestBody Persona per){
        interPersona.savePersona(per);
        return "La persona fue creada exitosamente";
    }
    
    @PutMapping ("/editar/persona/")
    public Persona edit2persona(@RequestBody Persona per){
                interPersona.savePersona(per);
        return per;
    }
    
    @GetMapping("/obtener/educacion")
    public List<Educacion> getEducacion(){
        return interEducacion.getEducacion();
    }
    @PostMapping ("/crear/educacion")
    public Educacion crearEducacion(@RequestBody Educacion edu){
        interEducacion.saveEducacion(edu);
        return edu;
    }
    
    @DeleteMapping ("/borrar/educacion/{id}")
    public List<Educacion> deleteEducacion(@PathVariable Long id){
        interEducacion.deleteEducacion(id);
        return interEducacion.getEducacion();
    }
    
        @PutMapping ("/editar/educacion/")
    public Educacion editEducacion(@RequestBody Educacion edu){
        interEducacion.saveEducacion(edu);
        return edu;
    }
    
    
        @GetMapping("/obtener/experiencia")
    public List<Experiencia> getExperiencia(){
        return interExperiencia.getExperiencia();
    }
        @PostMapping ("/crear/experiencia/")
    public Experiencia crearExperiencia(@RequestBody Experiencia exp){
        interExperiencia.saveExperiencia(exp);
        return exp;
    }
    
    @DeleteMapping ("/borrar/experiencia/{id}")
    public List<Experiencia> deleteExperiencia(@PathVariable Long id){
        interExperiencia.deleteExperiencia(id);
        return interExperiencia.getExperiencia() ;
    }
    
        @PutMapping ("/editar/experiencia/")
    public Experiencia editExperiencia(@RequestBody Experiencia exp){
        interExperiencia.saveExperiencia(exp);
        return exp;
    }
    
    
        @GetMapping("/obtener/proyecto")
    public List<Proyecto> getProyectos(){
        return interProyectos.getProyectos();
    }
    @PostMapping ("/crear/proyecto")
    public Proyecto crearProyectos(@RequestBody Proyecto proy){
        interProyectos.saveProyectos(proy);
        return proy;
    }
    
    @DeleteMapping ("/borrar/proyecto/{id}")
    public List<Proyecto> deleteProyectos(@PathVariable Long id){
        interProyectos.deleteProyectos(id);
        return interProyectos.getProyectos() ;
    }
    
    @PutMapping ("/editar/proyecto/")
    public Proyecto editProyecto(@RequestBody Proyecto proy){
        interProyectos.saveProyectos(proy);
        return proy;
    }
    
    
        @GetMapping("/obtener/skill")
    public List<Skill> getSkills(){
        return interSkills.getSkills();
    }
    @PostMapping ("/crear/skill")
    public Skill crearSkills(@RequestBody Skill skl){
        interSkills.saveSkills(skl);
        return skl;
    }
    
    @DeleteMapping ("/borrar/skill/{id}")
    public List<Skill> deleteSkills(@PathVariable Long id){
        interSkills.deleteSkills(id);
        return interSkills.getSkills();
    }
    
    @PutMapping ("/editar/skill/")
    public Skill editSkill(@RequestBody Skill skill){
        interSkills.saveSkills(skill);
        return skill;
    }
}
