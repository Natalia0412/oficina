package com.example.oficina.dto.mechanic;

import com.example.oficina.model.mechanic.enums.Mechanic_Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MechanicDto {

    private String name;

    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    private String phone;

    private String email;

    private List<String> specialties;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate hiringDate;

    private Integer serviceFee;

    private Mechanic_Status status;
}
