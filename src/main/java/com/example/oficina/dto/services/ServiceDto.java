package com.example.oficina.dto.services;

import com.example.oficina.model.car.Car;
import com.example.oficina.model.client.Client;
import com.example.oficina.model.mechanic.Mechanic;
import com.example.oficina.model.part.Part;
import com.example.oficina.model.services.enums.Service_Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceDto {
    private Client clientId;
    private Car carId;
    private Mechanic mechanicId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate serviceEstimatedDeliveryDate;
    private String description;
    private List<Part> parts;
    private Service_Status status;
}
