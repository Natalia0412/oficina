package com.example.oficina.dto.services;


import com.example.oficina.model.services.enums.Service_Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceDto {

    private String clientId;
    private String carId;
    private String mechanicId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate serviceEstimatedDeliveryDate;
    private String description;
    private List<PartServiceDto> parts;
    private Service_Status status;
}
