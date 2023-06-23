package com.example.oficina.dto.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartDto {
    private String title;
    private String description;
    private Integer qtd;
    private Float unitPrice;


}
