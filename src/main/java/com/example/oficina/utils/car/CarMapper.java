package com.example.oficina.utils.car;

import com.example.oficina.dto.car.CarDto;
import com.example.oficina.model.car.Car;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "license_plate", target = "licensePlate")
    void updateCarFromDto(CarDto dto, @MappingTarget Car car);
}
