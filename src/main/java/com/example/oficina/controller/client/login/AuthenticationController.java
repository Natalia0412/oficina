package com.example.oficina.controller.client.login;

import com.example.oficina.dto.login.LoginDto;
import com.example.oficina.model.client.Client;
import com.example.oficina.service.Authentication.TokenService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/client/login")
    public String login(@RequestBody LoginDto loginDto) {
        String token = null;
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
            Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            var usuario = (Client) authenticate.getPrincipal();
            token = this.tokenService.createTokenClient(usuario);
        return token;


    }

}
