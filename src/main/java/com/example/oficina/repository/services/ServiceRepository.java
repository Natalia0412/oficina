package com.example.oficina.repository.services;

import com.example.oficina.model.services.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Services, UUID> {
}
