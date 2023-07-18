package com.example.oficina.controller.car;

import com.example.oficina.dto.car.CarDto;
import com.example.oficina.model.car.Car;
import com.example.oficina.model.client.Client;
import com.example.oficina.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients/{idClient}/cars")
public class CarController {
    @Autowired
    private CarService service;

    @PostMapping()
    public ResponseEntity<Car> postCar(@PathVariable String idClient, @RequestBody CarDto carDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCar(idClient, carDto));
    }

    @GetMapping()
    public ResponseEntity<List<Car>>getCar(@RequestParam (required=false, defaultValue = "30")int limit, @RequestParam (required=false, defaultValue = "0")int offset) {
        return ResponseEntity.ok(service.getAll(limit, offset));
    }
    @GetMapping("/{idCar}")
    public ResponseEntity<Car> getCarbyId(@PathVariable String idClient, @PathVariable String idCar) {
        return ResponseEntity.ok(service.getCarById(idClient, idCar));
    }

    @PatchMapping("/{idCar}")
    public ResponseEntity<Car> updatePartial(@PathVariable String idClient, @PathVariable String idCar, @RequestBody CarDto carDto) {
        return ResponseEntity.ok(service.updatePartial(idClient,idCar,carDto));
    }

    @DeleteMapping("/{idCar}")
    public ResponseEntity<?> deleteCar(@PathVariable String idClient, @PathVariable String idCar) {
        service.deleteCar(idClient, idCar);
        return  ResponseEntity.noContent().build();
    }
}
