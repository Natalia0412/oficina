package com.example.oficina.dto.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartServiceDto {
    private UUID partId;
    private Integer qtd;
}
