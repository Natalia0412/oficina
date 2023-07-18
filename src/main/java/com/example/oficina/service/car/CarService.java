package com.example.oficina.service.car;

import com.example.oficina.dto.car.CarDto;
import com.example.oficina.map.car.CarMap;
import com.example.oficina.model.car.Car;
import com.example.oficina.model.client.Client;
import com.example.oficina.repository.car.CarRepository;
import com.example.oficina.service.client.ClientService;
import com.example.oficina.service.exceptions.ResourceBadRequestException;
import com.example.oficina.service.exceptions.ResourceNotFoundException;
import com.example.oficina.utils.OffsetBasedPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.oficina.utils.car.CarMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ClientService clientService;


    @Autowired
    private CarMapper mapper;

    public List<Car> getAll(int limit, int offset) {
        Pageable pageable = new OffsetBasedPageRequest(limit, offset, Sort.by(Sort.Direction.DESC, "id"));
        return carRepository.findAll(pageable).getContent();
    }

    public Car createCar(String idClient, CarDto carDto) {
        Client client = clientService.clientExist(idClient);
        boolean res = verifyLicensePlateExist(carDto.getLicense_plate());
        Car car = CarMap.carDtoToCar(carDto);
        car.setClient(client);
        return carRepository.save(car);
    }

    public Car getCarById(String idClient, String id) {
        Client client = clientService.clientExist(idClient);
        Optional<Car> obj = carRepository.findById(UUID.fromString(id));
        if (!obj.isPresent()) throw new ResourceNotFoundException("Car not found. id", id);
        return obj.get();
    }

    public void deleteCar(String idClient, String id) {
        Car car = this.getCarById(idClient, id);
        clientService.deleteCar(idClient, car);
    }

    public Car updatePartial(String idClient, String id, CarDto carDto) {
        Car car = this.getCarById(idClient, id);
        if (carDto.getLicense_plate() != null) this.verifyLicensePlateExist(carDto.getLicense_plate());

        mapper.updateCarFromDto(carDto, car);
        return carRepository.save(car);
    }

    public Boolean verifyLicensePlateExist(UUID licensePlate) {

        Boolean res = carRepository.existsByLicensePlate(licensePlate);

        if (res.booleanValue()) throw new ResourceBadRequestException("License Plate already exists");

        return false;
    }


}
