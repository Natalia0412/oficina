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
import com.example.oficina.service.exceptions.ResourceNotFoundException;
import com.example.oficina.service.mechanic.MechanicService;
import com.example.oficina.service.part.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.oficina.model.services.Services;

import java.util.List;
import java.util.Optional;
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

    public Services getByIdServices(String id) {
        Optional<Services> obj = serviceRepository.findById(UUID.fromString(id));
        if(!obj.isPresent()) throw new ResourceNotFoundException("Service not found. id", id);
        return obj.get();
    }

    public Services updatePartial (String id, ServiceDto dto) {
        Services services = this.getByIdServices(id);
        if(dto.getClientId() != null) {
            Client client = clientService.clientExist(dto.getClientId());
            services.setClient(client);
        }
        if(dto.getCarId() != null) {
            Car car = carService.getCarById(dto.getClientId(), dto.getCarId());
            services.setCar(car);
        }

        if(dto.getMechanicId() != null) {
            Mechanic mechanic = mechanicService.getMechanicById(dto.getMechanicId());
            services.setMechanic(mechanic);
        }

        if(dto.getParts() != null) {
            List<UUID> partIds = dto.getParts().stream().map(e -> e.getPartId()).collect(Collectors.toList());
            List<Part> partsOld = partService.getAllParts(partIds);
            partsOld.forEach(old -> dto.getParts().forEach(e -> {
                if (old.getId().equals(e.getPartId()) ) {
                    old.setQtd(e.getQtd());
                }
            }));

            services.setParts(partsOld);
        }

        if(dto.getServiceEstimatedDeliveryDate() != null) {
            services.setServiceEstimatedDeliveryDate(dto.getServiceEstimatedDeliveryDate());
        }

        if(dto.getDescription() != null) {
            services.setDescription(dto.getDescription());
        }

        if(dto.getStatus() != null) {
            services.setStatus(dto.getStatus());
        }

        return serviceRepository.save(services);

    }

}
