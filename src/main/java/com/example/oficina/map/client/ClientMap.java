package com.example.oficina.map.client;

import com.example.oficina.dto.client.ClientDto;
import com.example.oficina.dto.client.ClientDtoPagination;
import com.example.oficina.dto.client.ClientDtoResponse;
import com.example.oficina.model.client.Client;

public class ClientMap {
    public static Client clientDTOToClient (ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setCpfCnpj(clientDto.getCpf_cnpj());
        client.setClient_type(clientDto.getClient_type());
        client.setBirthday(clientDto.getBirthday());
        client.setPhone(clientDto.getPhone());
        client.setEmail(clientDto.getEmail());
        client.setPassword(clientDto.getPassword());
        client.setZipCode(clientDto.getZipCode());
        client.setStreet(clientDto.getStreet());
        client.setNumber(clientDto.getNumber());
        client.setNeighbourhood(clientDto.getNeighbourhood());
        client.setCity(clientDto.getCity());
        return client;
    }

    public static ClientDtoResponse clientToClientDTO (Client client) {
        ClientDtoResponse clientDto = new ClientDtoResponse();
        clientDto.setId(client.getId());
        clientDto.setName(client.getName());
        clientDto.setCpf_cnpj(client.getCpfCnpj());
        clientDto.setClient_type(client.getClient_type());
        clientDto.setBirthday(client.getBirthday());
        clientDto.setPhone(client.getPhone());
        clientDto.setEmail(client.getEmail());
        clientDto.setZipCode(client.getZipCode());
        clientDto.setStreet(client.getStreet());
        clientDto.setNumber(client.getNumber());
        clientDto.setNeighbourhood(client.getNeighbourhood());
        clientDto.setCity(client.getCity());
        return clientDto;
    }

    public static ClientDtoPagination clientDtoResponsePagination(Long count, int limit, int offset, Client client) {
        ClientDtoPagination cli = new ClientDtoPagination();
        cli.setLimit(limit);
        cli.setOffset(offset);
        cli.setTotal(count);
        cli.setId(client.getId());
        cli.setName(client.getName());
        cli.setCpf_cnpj(client.getCpfCnpj());
        cli.setClient_type(client.getClient_type());
        cli.setBirthday(client.getBirthday());
        cli.setPhone(client.getPhone());
        cli.setEmail(client.getEmail());
        cli.setZipCode(client.getZipCode());
        cli.setStreet(client.getStreet());
        cli.setNumber(client.getNumber());
        cli.setNeighbourhood(client.getNeighbourhood());
        cli.setCity(client.getCity());
        return cli;
    }


}
