package com.example.oficina.map.services;

import com.example.oficina.dto.services.ServiceDto;
import com.example.oficina.model.services.Services;

public class ServicesMap {
    public static Services servicesDtoToService (ServiceDto dto) {
        Services services = new Services();
        services.setClient(dto.getClientId());
        services.setCar(dto.getCarId());
        services.setMechanic(dto.getMechanicId());
        services.setServiceEstimatedDeliveryDate(dto.getServiceEstimatedDeliveryDate());
        services.setDescription(dto.getDescription());
        services.setParts(dto.getParts());
        services.setStatus(dto.getStatus());
        return services;
    }
}
