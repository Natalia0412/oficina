package com.example.oficina.service.Authentication;

import com.example.oficina.model.client.Client;
import com.example.oficina.repository.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AuthenticationService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException{
//        Optional<Client> optional = clientRepository.findByEmail(username);
//        if(optional.isPresent()) {
//            return optional.get();
//        }
//        throw new UsernameNotFoundException("User not found");
        return clientRepository.findByEmail(username);
    }
}
