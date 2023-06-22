package com.ltp.contacts.security;


import java.lang.reflect.Method;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

// Classe que vai lidar com os REQUESTS
// BASIC authentication
@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private BCryptPasswordEncoder passwordEncoder;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Basicamente, todo request HTTP: 
        // Precisa ser autorizado
        // Passar pela autenticação ( para ser válido )
        // Para ser "buildado" em um objeto ( bean )
        // Sem cookies ou requests de sessão ( todo request precisa ser autenticado )
        http
        .csrf().disable()   // CSRF protection of
        .authorizeRequests()
        .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN") // APENAS ADMINS podem fazer DELETES
        .requestMatchers(HttpMethod.POST).hasAnyRole("ADMIN","USER") // Ambos usuários podem fazer POST
        .requestMatchers(HttpMethod.GET).permitAll() // GET não precisa de autenticação, credenciais, etc APENAS o HTTP
        .anyRequest().authenticated()
        .and()
        .httpBasic()
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // NO COKKIES or session based requests

        return http.build();
    }

    // Quais users temos
    @Bean
    public UserDetailsService users(){

        // Build a user that has:
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder.encode("admin-pass")) // Salvar o password encryptado
            .roles("ADMIN")
            .build();

        // Build another user that has:
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder.encode("user-pass")) // Salvar o password encryptado
            .roles("USER")
            .build();

        // Apenas admin é APROVADO
        return new InMemoryUserDetailsManager(admin, user);
    }
}


