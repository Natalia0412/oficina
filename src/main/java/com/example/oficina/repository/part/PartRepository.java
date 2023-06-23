package com.example.oficina.repository.part;

import com.example.oficina.model.part.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartRepository extends JpaRepository<Part, UUID> {
}
