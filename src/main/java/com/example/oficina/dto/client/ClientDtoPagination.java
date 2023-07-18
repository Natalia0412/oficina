package com.example.oficina.dto.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDtoPagination {
    private Integer limit;
    private Integer offset;
    //    private Long total;
    private List<ClientDtoResponse> items;
}
