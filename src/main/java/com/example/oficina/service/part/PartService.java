package com.example.oficina.service.part;

import com.example.oficina.dto.part.PartDto;
import com.example.oficina.map.part.PartMap;
import com.example.oficina.model.part.Part;
import com.example.oficina.repository.part.PartRepository;
import com.example.oficina.service.exceptions.ResourceIlegalArgumentException;
import com.example.oficina.service.exceptions.ResourceNotFoundException;
import com.example.oficina.utils.part.PartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartService {
    @Autowired
    private PartRepository partRepository;

    @Autowired
    private PartMapper mapper;

    public Part createPart(PartDto partDto) {
        return partRepository.save(PartMap.partDtoToPart(partDto));
    }

    public Part getByIdPart(String id) {
        Optional<Part> obj = partRepository.findById(UUID.fromString(id));
        if (!obj.isPresent()) throw new ResourceNotFoundException("Part not found. Id ", id);
        return obj.get();
    }

    public Part updatePartialPart(String id, PartDto body) {
        Part part = this.getByIdPart(id);
        mapper.updatePartFromDto(body, part);
        return partRepository.save(part);
    }

    public List<Part> getAllParts(List<UUID> ids) {
        List<Part> partsResponse =  partRepository.findAllById(ids);
        if (partsResponse.isEmpty()) throw new ResourceIlegalArgumentException("At least one, id not found");
        return partsResponse;
    }
}
