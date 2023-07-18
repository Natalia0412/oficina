package com.example.oficina.service.mechanic;

import com.example.oficina.dto.mechanic.MechanicDto;
import com.example.oficina.map.mechanic.MechanicMap;
import com.example.oficina.model.mechanic.Mechanic;
import com.example.oficina.repository.mechanic.MechanicRepository;
import com.example.oficina.service.exceptions.ResourceBadRequestException;
import com.example.oficina.service.exceptions.ResourceNotFoundException;
import com.example.oficina.utils.OffsetBasedPageRequest;
import com.example.oficina.utils.mechanic.MechanicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MechanicService {
    @Autowired
    private MechanicRepository mechanicRepository;

    @Autowired
    private MechanicMapper mapper;
    
    public Mechanic createMechanic(MechanicDto body){
        this.verifyCpfExist(body);
        this.verifyEmailExist(body);
        return mechanicRepository.save(MechanicMap.mechanicDtoToMechanic(body));
    }

    public List<Mechanic> getAll(int limit, int offset) {
        Pageable pageable = new OffsetBasedPageRequest(limit, offset, Sort.by(Sort.Direction.DESC, "id"));
        return mechanicRepository.findAll(pageable).getContent();
    }

    public Mechanic getMechanicById(String id) {
        Optional<Mechanic> obj = mechanicRepository.findById(UUID.fromString(id));
        if(!obj.isPresent()) throw new ResourceNotFoundException("Mechanic not found. Id ", id);
        return obj.get();
    }

    public Mechanic updatePartial(String id, MechanicDto body) {
        Mechanic mechanic = this.getMechanicById(id);
        if(body.getCpf() != null) this.verifyCpfExist(body);
        if(body.getEmail() != null)  this.verifyEmailExist(body);

        mapper.updateMechanicFromDto(body, mechanic);
        return mechanicRepository.save(mechanic);
    }
    public void verifyCpfExist(MechanicDto body) {
        Mechanic res = mechanicRepository.findByCpf(body.getCpf());
        if (res != null) throw new ResourceBadRequestException("cpf is already exists");
    }

    public void verifyEmailExist(MechanicDto body) {
        Mechanic mechanic = mechanicRepository.findByEmail(body.getEmail());
        if (mechanic != null) throw new ResourceBadRequestException("Email is already exists");
    }

    public Mechanic verifyEmailExist(String email) {
        return mechanicRepository.findByEmail(email);
    }


}
