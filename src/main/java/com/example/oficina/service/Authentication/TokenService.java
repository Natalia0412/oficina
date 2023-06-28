package com.example.oficina.service.Authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.oficina.model.client.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    public String createTokenClient(Client client) {
        String id = client.getId().toString();
        return JWT.create()
                .withIssuer("Client")
                .withSubject(client.getUsername())
                .withClaim("id", id)
                .withExpiresAt(Date.from(LocalDateTime.now()
                        .plusMinutes(10)
                        .toInstant(ZoneOffset.of("-03:00"))))
                .sign(Algorithm.HMAC256("secreta"));


    }
}
