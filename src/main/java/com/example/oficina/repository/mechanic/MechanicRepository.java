package com.example.oficina.repository.mechanic;

import com.example.oficina.model.mechanic.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MechanicRepository extends JpaRepository<Mechanic, UUID> {

    Mechanic findByCpf(String cpf);

    Mechanic findByEmail(String email);



}
