package com.example.oficina.service.services;

<<<<<<< HEAD
import com.example.oficina.dto.services.ServiceDto;
import com.example.oficina.map.services.ServicesMap;
=======
>>>>>>> 809778080c47413e1e0100ec2203ba01acd30381
import com.example.oficina.repository.services.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.oficina.model.services.Services;

@Service
public class ServicesService {
    @Autowired
    private ServiceRepository serviceRepository;

<<<<<<< HEAD
    public Services createServices(ServiceDto dto) {
        return serviceRepository.save(ServicesMap.servicesDtoToService(dto));
    }
=======
    public Services
>>>>>>> 809778080c47413e1e0100ec2203ba01acd30381
}
