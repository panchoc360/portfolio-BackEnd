package com.portafolio.BackEnd;

import com.portafolio.BackEnd.service.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


//@CrossOrigin(origins = {"http://localhost:4200", "https://portfolio-frontend-c8e8e.web.app/"})
@SpringBootApplication
public class BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors()
                    .and().authorizeRequests()
                    .antMatchers(HttpMethod.POST, "http://localhost:4200/iniciarsesion").permitAll()
                    .antMatchers(HttpMethod.GET).permitAll()
                    .anyRequest().permitAll();
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests();
                    

        }

}
    }

