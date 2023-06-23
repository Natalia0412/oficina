package com.example.oficina.utils.mechanic;
import com.example.oficina.dto.mechanic.MechanicDto;
import com.example.oficina.model.mechanic.Mechanic;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MechanicMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMechanicFromDto(MechanicDto dto, @MappingTarget Mechanic mechanic);
}
