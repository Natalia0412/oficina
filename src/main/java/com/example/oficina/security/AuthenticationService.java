package com.example.oficina.security;

import com.example.oficina.model.client.Client;
import com.example.oficina.model.mechanic.Mechanic;
import com.example.oficina.service.client.ClientService;
import com.example.oficina.service.mechanic.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private MechanicService mechanicService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        Client client = clientService.verifyEmailExist(email);
        if (client !=  null) {
            userDetails =  client;
        }else {
            Mechanic mechanic = mechanicService.verifyEmailExist(email);
            if (mechanic != null) {
                userDetails = (UserDetails) mechanic;
            }
        }
        return userDetails;
    }


}
