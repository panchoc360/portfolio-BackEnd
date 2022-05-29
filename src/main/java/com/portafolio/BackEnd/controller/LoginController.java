/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.controller;

import com.portafolio.BackEnd.model.Usuario;
import com.portafolio.BackEnd.service.UsuarioService;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;


/**
 *
 * @author Francisco
 */

@RestController
public class LoginController {
    
    @Autowired
    private UsuarioService interUsuario;
            
    @PostMapping("iniciarsesion")
	public ResponseEntity<Usuario> login(@RequestParam("email") String email, @RequestParam("password") String pwd) {
		Usuario usuario = interUsuario.findById(email);
                
                if (usuario != null && (usuario.getContra() == null ? pwd == null : usuario.getContra().equals(pwd)))
                        {
		String token = getJWTToken(email);
		Usuario user = new Usuario();
		user.setEmail(email);
		user.setToken(token);		
		return new ResponseEntity(user, HttpStatus.OK);
                        }
                else
                    return new ResponseEntity("Email o contraseña incorrectas", HttpStatus.UNAUTHORIZED);
                     
	}

	private String getJWTToken(String email) {
		String secretKey = "WebFullStack";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(email)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
