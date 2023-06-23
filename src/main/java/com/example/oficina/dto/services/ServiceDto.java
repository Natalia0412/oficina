package com.example.oficina.dto.services;

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
    private UUID clientId;
    private UUID carId;
    private UUID mechanicId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate serviceEstimatedDeliveryDate;
    private String description;
    private List<PartServiceDto> parts;
    private Service_Status status;
}
