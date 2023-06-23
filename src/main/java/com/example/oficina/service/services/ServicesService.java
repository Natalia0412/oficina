package com.example.oficina.service.services;

import com.example.oficina.dto.services.ServiceDto;
import com.example.oficina.map.services.ServicesMap;
import com.example.oficina.model.car.Car;
import com.example.oficina.model.client.Client;
import com.example.oficina.model.mechanic.Mechanic;
import com.example.oficina.model.part.Part;
import com.example.oficina.repository.services.ServiceRepository;
import com.example.oficina.service.car.CarService;
import com.example.oficina.service.client.ClientService;
import com.example.oficina.service.mechanic.MechanicService;
import com.example.oficina.service.part.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.oficina.model.services.Services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ServicesService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CarService carService;

    @Autowired
    private MechanicService mechanicService;

    @Autowired
    private PartService partService;

    public Services createServices(ServiceDto dto) {
        Client client = clientService.clientExist(dto.getClientId());
        Car car = carService.getCarById(dto.getClientId(), dto.getCarId());
        Mechanic mechanic = mechanicService.getMechanicById(dto.getMechanicId());
        List<UUID> partIds = dto.getParts().stream().map(e -> e.getPartId()).collect(Collectors.toList());
        List<Part> partsOld = partService.getAllParts(partIds);
        partsOld.forEach(old -> dto.getParts().forEach(e -> {
            if (old.getId().equals(e.getPartId()) ) {
                old.setQtd(e.getQtd());
            }
        }));
        Services services = ServicesMap.servicesDtoToService(dto);
        services.setClient(client);
        services.setCar(car);
        services.setMechanic(mechanic);
        services.setParts(partsOld);
        return serviceRepository.save(services);
    }

}
