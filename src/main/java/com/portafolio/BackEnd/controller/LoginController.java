/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.BackEnd.controller;

import com.portafolio.BackEnd.model.Usuario;
import com.portafolio.BackEnd.service.UsuarioService;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @author Francisco
 */

@RestController
@CrossOrigin
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST}, preflightContinue: false)
//@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-frontend-c8e8e.web.app/"})
public class LoginController {
    
    @Autowired
    private UsuarioService interUsuario;
            
    @PostMapping("/iniciarsesion")
    	public ResponseEntity<Usuario> login(@RequestBody Usuario edu) {
		Usuario usuario = interUsuario.findById(edu.getEmail());
                
                if (usuario != null && (usuario.getContra() == null ? edu.getContra() == null : usuario.getContra().equals(edu.getContra())))
                        {
		String token = getJWTToken(edu.getEmail());
		Usuario user = new Usuario();
		user.setEmail(edu.getEmail());
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
