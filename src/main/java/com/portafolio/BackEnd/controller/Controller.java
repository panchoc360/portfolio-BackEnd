/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.controller;

import com.portafolio.BackEnd.model.Persona;
import com.portafolio.BackEnd.service.EducacionService;
import com.portafolio.BackEnd.service.ExperienciaService;
import com.portafolio.BackEnd.service.PersonaService;
import com.portafolio.BackEnd.service.ProyectosService;
import com.portafolio.BackEnd.service.SkillsService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Francisco
 */
@RestController
public class Controller {
    
    @Autowired
    private PersonaService interPersona;
    @Autowired
    private EducacionService interEducacion;
    @Autowired
    private ExperienciaService interExperiencia;
    @Autowired
    private ProyectosService interProyectos;
    @Autowired
    private SkillsService interSkills;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }
        @GetMapping("/personas/traer/{id}")
    public Persona getPersonasobjeto(@PathVariable Long id){
        return interPersona.findPersona(id);
    }
    
    @PostMapping ("/personas/crear")
    public String createStudent(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "La persona fue creada exitosamente";
    }
    
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        interPersona.deletePersona(id);
        return "La persona fue eliminada exitosamente";
    }
    
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("email") String nuevoEmail,
            @RequestParam("telefono") String nuevoTelefono
            ){
        Persona perso = interPersona.findPersona(id);
        perso.setNombre (nuevoNombre);
        perso.setEmail(nuevoEmail);
        perso.setTelefono(nuevoTelefono);
        
        interPersona.savePersona(perso);
        return perso;
    }
    
}
