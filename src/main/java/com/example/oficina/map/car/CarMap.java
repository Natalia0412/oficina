package com.example.oficina.map.car;

import com.example.oficina.dto.car.CarDto;
import com.example.oficina.model.car.Car;

public class CarMap {
    public static Car carDtoToCar (CarDto carDto) {
        Car car = new Car();
        car.setLicensePlate(carDto.getLicense_plate());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());
        car.setManufacturer(carDto.getManufacturer());
        car.setColor(carDto.getColor());
        return car;
    }
}
