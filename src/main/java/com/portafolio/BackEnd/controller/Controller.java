/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.controller;

import com.portafolio.BackEnd.model.Educacion;
import com.portafolio.BackEnd.model.Experiencia;
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
    
    @GetMapping("/persona/obtenerdatos")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }

    @PostMapping ("/crear/educacion")
    public String crearEducacion(@RequestBody Educacion edu){
        interEducacion.saveEducacion(edu);
        return "La educacion fue creada exitosamente";
    }
    
    @DeleteMapping ("/borrar/educacion/{id}")
    public String deleteEducacion(@PathVariable Long id){
        interEducacion.deleteEducacion(id);
        return "La Educación fue eliminada exitosamente";
    }
    
    @PutMapping ("/editar/educacion/{id}")
    public Educacion editEducacion(@PathVariable Long id,
            @RequestParam("nombreInstitucion") String nuevoNombre,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("inicio") int nuevoInicio,
            @RequestParam("fin") int nuevoFin,
            @RequestParam("urlImagen") String nuevaUrl
            ){
        Educacion edu = interEducacion.findEducacion(id);
        edu.setNombreInstitucion(nuevoNombre);
        edu.setTitulo(nuevoTitulo);
        edu.setInicio(nuevoInicio);
        edu.setFin(nuevoFin);
        edu.setUrlImagen(nuevaUrl);
        
        interEducacion.saveEducacion(edu);
        return edu;
    }
    
        @PostMapping ("/crear/experiencia")
    public String crearExperiencia(@RequestBody Experiencia exp){
        interExperiencia.saveExperiencia(exp);
        return "La Experiencia fue creada exitosamente";
    }
    
    @DeleteMapping ("/borrar/experiencia/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        interExperiencia.deleteExperiencia(id);
        return "La Experiencia fue eliminada exitosamente";
    }
    
    @PutMapping ("/editar/experiencia/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
            @RequestParam("nombreLugar") String nuevoNombre,
            @RequestParam("cargoOcupado") String nuevoCargo,
            @RequestParam("inicio") int nuevoInicio,
            @RequestParam("fin") int nuevoFin,
            @RequestParam("descripcion") String nuevaDescripcion
            ){
        Experiencia exp = interExperiencia.findExperiencia(id);
        exp.setNombreLugar(nuevoNombre);
        exp.setCargoOcupado(nuevoCargo);
        exp.setInicio(nuevoInicio);
        exp.setFin(nuevoFin);
        exp.setDescripcion(nuevaDescripcion);
        
        interExperiencia.saveExperiencia(exp);
        return exp;
    }
}
