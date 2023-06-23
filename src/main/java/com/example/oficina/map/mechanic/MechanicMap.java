package com.example.oficina.map.mechanic;

import com.example.oficina.dto.mechanic.MechanicDto;
import com.example.oficina.model.mechanic.Mechanic;

public class MechanicMap {

    public static Mechanic mechanicDtoToMechanic (MechanicDto dto) {
        Mechanic mechanic = new Mechanic();
        mechanic.setName(dto.getName());
        mechanic.setCpf(dto.getCpf());
        mechanic.setBirthday(dto.getBirthday());
        mechanic.setPhone(dto.getPhone());
        mechanic.setEmail(dto.getEmail());
        mechanic.setSpecialties(dto.getSpecialties());
        mechanic.setHiringDate(dto.getHiringDate());
        mechanic.setServiceFee(dto.getServiceFee());
        mechanic.setStatus(dto.getStatus());
        return mechanic;
    }
}
