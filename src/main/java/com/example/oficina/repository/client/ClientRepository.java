package com.example.oficina.repository.client;

import com.example.oficina.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    Boolean existsByEmail(String email);

    Optional<Client> findByEmail(String email);
//    Client findByEmail(String email);

    Boolean existsByCpfCnpj(String cpf_cnpj);

}
