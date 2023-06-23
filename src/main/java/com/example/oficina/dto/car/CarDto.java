package com.example.oficina.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {

    private UUID  license_plate;

    private String model;

    private Integer year;

    private String manufacturer;

    private String color;
}
