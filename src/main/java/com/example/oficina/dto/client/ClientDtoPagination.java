package com.example.oficina.dto.client;

import com.example.oficina.model.client.enums.Client_Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDtoPagination {
    private Integer limit;
    private Integer offset;
    private Long total ;
    private UUID id;
    private String name;
    private String cpf_cnpj;
    private Client_Type client_type;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthday;
    private String phone;
    private String email;
    private String zipCode;
    private String street;
    private String number;
    private String neighbourhood;
    private String city;
}
