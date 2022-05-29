/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Usuario;
import com.portafolio.BackEnd.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco
 */
@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioRepository UsuarioRepository;
    
    @Override
    public List<Usuario> getUsuario(){
        List<Usuario> listaUsuario = UsuarioRepository.findAll();
        return listaUsuario;
    }
    @Override
    public void saveUsuario (Usuario usuario){
        UsuarioRepository.save(usuario);
    }
    
    @Override
    public void deleteUsuario (String id){
        UsuarioRepository.deleteById(id);
    }
    
    @Override
    public Usuario findById (String email){
        Usuario usuario = UsuarioRepository.findById(email).orElse(null);
        return usuario;
    }
}
