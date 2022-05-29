/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.BackEnd.service;

import com.portafolio.BackEnd.model.Usuario;
import java.util.List;

/**
 *
 * @author Francisco
 */
public interface IUsuarioService {
    
    public List<Usuario> getUsuario();
    
    public void saveUsuario (Usuario user);
    
    public void deleteUsuario (String id);
    
    public Usuario findById (String email);
}

