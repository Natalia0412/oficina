package com.example.oficina.service.services;

import com.example.oficina.dto.services.ServiceDto;
import com.example.oficina.map.services.ServicesMap;
import com.example.oficina.repository.services.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.oficina.model.services.Services;

@Service
public class ServicesService {
    @Autowired
    private ServiceRepository serviceRepository;

    public Services createServices(ServiceDto dto) {
        return serviceRepository.save(ServicesMap.servicesDtoToService(dto));
    }
}
