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
    private ProyectoService interProyectos;
    @Autowired
    private SkillService interSkills;

    
    @GetMapping("/obtener/portfolio")
    public PortfolioDTO getPortfolio(){
        
        return new PortfolioDTO(interPersona.getPersonas(),
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
    
    @PutMapping ("/editar/persona/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("email") String nuevoEmail,
            @RequestParam("telefono") String nuevoTelefono,
            @RequestParam("acercade") String nuevoAcercaDe,
            @RequestParam("urlimagenPerfil") String nuevaUrlPerfil,
            @RequestParam("urlImagenPortada") String nuevaUrlPortada){
        Persona per = interPersona.findPersona(id);
        per.setNombre(nuevoNombre);
        per.setEmail(nuevoEmail);
        per.setTelefono(nuevoTelefono);
        per.setAcercade(nuevoAcercaDe);
        per.setUrlImagenPerfil(nuevaUrlPerfil);
        per.setUrlImagenPortada(nuevaUrlPortada);
        
        interPersona.savePersona(per);
        return per;
    }
    
    
    @GetMapping("/obtener/educacion")
    public List<Educacion> getEducacion(){
        return interEducacion.getEducacion();
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
    
    
    
        @GetMapping("/obtener/experiencia")
    public List<Experiencia> getExperiencia(){
        return interExperiencia.getExperiencia();
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
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("urlLogo") String urlLogo,
            @RequestParam("urlWebPage") String urlWebPage
            ){
        Experiencia exp = interExperiencia.findExperiencia(id);
        exp.setNombreLugar(nuevoNombre);
        exp.setCargoOcupado(nuevoCargo);
        exp.setInicio(nuevoInicio);
        exp.setFin(nuevoFin);
        exp.setDescripcion(nuevaDescripcion);
        exp.setUrlLogo(urlLogo);
        exp.setUrlWebPage(urlWebPage);
        
        interExperiencia.saveExperiencia(exp);
        return exp;
    }
    
    
        @GetMapping("/obtener/proyecto")
    public List<Proyecto> getProyectos(){
        return interProyectos.getProyectos();
    }
    @PostMapping ("/crear/proyecto")
    public String crearProyectos(@RequestBody Proyecto proy){
        interProyectos.saveProyectos(proy);
        return "El proyecto fue creado exitosamente";
    }
    
    @DeleteMapping ("/borrar/proyecto/{id}")
    public String deleteProyectos(@PathVariable Long id){
        interProyectos.deleteProyectos(id);
        return "El proyecto fue eliminado exitosamente";
    }
    
    @PutMapping ("/editar/proyecto/{id}")
    public Proyecto editProyecto(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("fecha") int nuevaFecha,
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("url") String nuevaURL,
            @RequestParam("urlImagen") String nuevaUrlImagen
            ){
        Proyecto proy = interProyectos.findProyectos(id);
        proy.setNombre(nuevoNombre);
        proy.setFecha(nuevaFecha);
        proy.setDescripcion(nuevaDescripcion);
        proy.setUrl(nuevaURL);
        proy.setUrlImagen(nuevaUrlImagen);
        
        interProyectos.saveProyectos(proy);
        return proy;
    }
    
    
        @GetMapping("/obtener/skill")
    public List<Skill> getSkills(){
        return interSkills.getSkills();
    }
    @PostMapping ("/crear/skill")
    public String crearSkills(@RequestBody Skill skl){
        interSkills.saveSkills(skl);
        return "La habilidad fue creada exitosamente";
    }
    
    @DeleteMapping ("/borrar/skill/{id}")
    public String deleteSkills(@PathVariable Long id){
        interSkills.deleteSkills(id);
        return "La habilidad fue eliminada exitosamente";
    }
    
    @PutMapping ("/editar/skill/{id}")
    public Skill editSkill(@PathVariable Long id,
            @RequestParam("skill") String skills,
            @RequestParam("nivel") int nivel
            ){
        Skill skill = interSkills.findSkills(id);
        skill.setSkill(skills);
        skill.setNivel(nivel);

        
        interSkills.saveSkills(skill);
        return skill;
    }
}
