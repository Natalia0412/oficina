package com.example.oficina.service.client;

import com.example.oficina.dto.client.ClientDto;
import com.example.oficina.dto.client.ClientDtoResponse;
import com.example.oficina.map.client.ClientMap;
import com.example.oficina.model.car.Car;
import com.example.oficina.model.client.Client;
import com.example.oficina.repository.client.ClientRepository;
import com.example.oficina.service.exceptions.ResourceBadRequestException;
import com.example.oficina.service.exceptions.ResourceNotFoundException;
import com.example.oficina.utils.client.ClientMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientMapper mapper;

    public ClientDtoResponse createClient(ClientDto body) {
        Boolean emailExist = verifyEmailExist(body);

        Boolean cpfCnpjExist = verifyCpfCnpjExist(body);

        if (emailExist) throw new ResourceBadRequestException("Email is already exists");

        if (cpfCnpjExist) throw new ResourceBadRequestException("cpf_cnpj is already exists");

        String encryptedPassword = encryptPassword(body.getPassword());

        body.setPassword(encryptedPassword);

        Client client = repository.save(ClientMap.clientDTOToClient(body));

        return ClientMap.clientToClientDTO(client);

    }

    public boolean verifyEmailExist(ClientDto body) {
        return repository.existsByEmail(body.getEmail());
    }

//    public Client verifyEmailExist(String email) {
//        return repository.findByLogin(email);
//    }


    public Boolean verifyCpfCnpjExist(ClientDto body) {
        return repository.existsByCpfCnpj(body.getCpf_cnpj());
    }

    public String encryptPassword(String password) {
        BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();

        return encrypt.encode(password);
    }

    public void getAllClient(int limit, int offset) {
        long total = repository.count();
//        Page<Client> page = repository.findAll(
//                PageRequest.of(limit, offset));

        // System.out.println("total" +total);
        //System.out.println(page);
    }

    public List<Client> getAll() {
        return repository.findAll();
    }

    public ClientDtoResponse getClientById(String id) {
        Optional<Client> obj = repository.findById(UUID.fromString(id));
        if (!obj.isPresent()) throw new ResourceNotFoundException("Resource not found. Id ", id);
        return ClientMap.clientToClientDTO(obj.get());
    }

    public ClientDtoResponse updatePartial(String id, ClientDto clientDto) {
        Optional<Client> obj = repository.findById(UUID.fromString(id));

        if (!obj.isPresent()) throw new ResourceNotFoundException("Resource not found. Id ", id);

        if (clientDto.getPassword() != null) {
            String encryptedPassword = encryptPassword(clientDto.getPassword());
            clientDto.setPassword(encryptedPassword);
        }

        if (clientDto.getEmail() != null) {
            Boolean emailExist = verifyEmailExist(clientDto);
            if (emailExist) throw new ResourceBadRequestException("Email is already exists");
        }

        if (clientDto.getCpf_cnpj() != null) {
            Boolean cpfCnpjExist = verifyCpfCnpjExist(clientDto);
            if (cpfCnpjExist) throw new ResourceBadRequestException("cpf_cnpj is already exists");
        }

        mapper.updateClientFromDto(clientDto, obj.get());
        Client clientToUpdate = repository.save(obj.get());
        return ClientMap.clientToClientDTO(clientToUpdate);
    }

    //testar polimorfismo
    public Client clientExist(String id) {
        Optional<Client> obj = repository.findById(UUID.fromString(id));
        if (!obj.isPresent()) throw new ResourceNotFoundException("Client not found. Id ", id);
        return obj.get();
    }

    public Client deleteCar(String idClient, Car car) {
        Client client = this.clientExist(idClient);
        client.removeCar(car);
        return repository.save(client);
    }


}
