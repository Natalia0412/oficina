package com.example.oficina.service.Authentication;

import com.example.oficina.model.client.Client;
import com.example.oficina.repository.client.ClientRepository;
import com.example.oficina.service.exceptions.ResourceNotFoundException;
import com.example.oficina.service.exceptions.ResourceUserNameNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Client  optional = clientRepository.findByEmail(username);
        if (optional != null) {
            return optional;
        }
        throw new ResourceUserNameNotFound("invalid email or password");

    }
}
