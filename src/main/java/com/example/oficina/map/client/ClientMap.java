package com.example.oficina.map.client;

import com.example.oficina.dto.client.ClientDto;
import com.example.oficina.dto.client.ClientDtoPagination;
import com.example.oficina.dto.client.ClientDtoResponse;
import com.example.oficina.model.client.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMap {
    public static Client clientDTOToClient(ClientDto clientDto) {
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

    public static ClientDtoResponse clientToClientDTO(Client client) {
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

    public static List<ClientDtoResponse> clientToClientDtoPagination(List<Client> clients) {
        return clients.stream().map(e -> ClientMap.clientToClientDTO(e)).collect(Collectors.toList());
    }

    public static ClientDtoPagination clientDtoResponsePagination(int limit, int offset, List<ClientDtoResponse> clientDtoResponseList) {
        ClientDtoPagination cli = new ClientDtoPagination();
        cli.setLimit(limit);
        cli.setOffset(offset);
        cli.setItems(clientDtoResponseList);
        return cli;
    }


}
