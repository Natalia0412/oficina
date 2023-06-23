package com.example.oficina.repository.car;

import com.example.oficina.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    boolean existsByLicensePlate(UUID licensePlate);
}
