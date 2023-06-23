package com.example.oficina.utils.part;

import com.example.oficina.dto.part.PartDto;
import com.example.oficina.model.part.Part;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PartMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePartFromDto(PartDto dto, @MappingTarget Part part);
}
