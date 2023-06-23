package com.example.oficina.utils.client;

import com.example.oficina.dto.client.ClientDto;
import com.example.oficina.model.client.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "cpf_cnpj", target = "cpfCnpj")
    void updateClientFromDto(ClientDto dto, @MappingTarget Client client);
}
