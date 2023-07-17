package com.example.oficina.security;

import com.example.oficina.model.client.Client;
import com.example.oficina.repository.client.ClientRepository;
import com.example.oficina.service.Authentication.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
@Service
public class FilterToken extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request.isRequestedSessionIdFromURL());
        String token;
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            token = authorizationHeader.replace("Bearer ", "");
            String subject = this.tokenService.getSubject(token);
            Client user = this.clientRepository.findByEmail(subject);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
