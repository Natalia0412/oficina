package com.example.oficina.dto.client;

import com.example.oficina.model.client.enums.Client_Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String name;
    //@JsonProperty("cpf_cnpj")
    private String cpf_cnpj;
    private Client_Type client_type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthday;
    private String phone;
    private String email;
    private String password;
    private String zipCode;
    private String street;
    private String number;
    private String neighbourhood;
    private String city;
}
