package com.example.oficina.controller.services;

import com.example.oficina.dto.services.ServiceDto;
import com.example.oficina.model.services.Services;
import com.example.oficina.service.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/services")
public class ServicesController {
    @Autowired
    private ServicesService service;

    @PostMapping
    public ResponseEntity<Services> addService (@RequestBody ServiceDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createServices(dto));
    }

}
