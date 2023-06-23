package com.example.oficina.dto.services;

<<<<<<< HEAD
import com.example.oficina.model.car.Car;
import com.example.oficina.model.client.Client;
import com.example.oficina.model.mechanic.Mechanic;
=======
>>>>>>> 809778080c47413e1e0100ec2203ba01acd30381
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
<<<<<<< HEAD
    private Client clientId;
    private Car carId;
    private Mechanic mechanicId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate serviceEstimatedDeliveryDate;
    private String description;
    private List<Part> parts;
=======
    private UUID clientId;
    private UUID carId;
    private UUID mechanicId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate serviceEstimatedDeliveryDate;
    private String description;
    private List<PartServiceDto> parts;
>>>>>>> 809778080c47413e1e0100ec2203ba01acd30381
    private Service_Status status;
}
