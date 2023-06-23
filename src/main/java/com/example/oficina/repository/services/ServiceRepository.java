package com.example.oficina.repository.services;

import com.example.oficina.model.services.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ServiceRepository extends JpaRepository<Services, UUID> {
}
