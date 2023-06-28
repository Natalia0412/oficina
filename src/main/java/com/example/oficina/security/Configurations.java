package com.example.oficina.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Configurations {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/client/login")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/mechanic/login")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/clients")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/clients")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/mechanics")
                .permitAll()
                .anyRequest().authenticated().and().build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
}
