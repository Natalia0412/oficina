package com.example.oficina.controller.services;

import com.example.oficina.dto.services.ServiceDto;
import com.example.oficina.model.services.Services;
import com.example.oficina.service.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/services")
public class ServicesController {
    @Autowired
    private ServicesService service;

    @PostMapping
    public ResponseEntity<Services> addServices (@RequestBody ServiceDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createServices(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> getByIdServices (@PathVariable String id) {
        return ResponseEntity.ok(service.getByIdServices(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Services> UpdatePartialServices (@PathVariable String id ,@RequestBody ServiceDto dto) {
        return ResponseEntity.ok(service.updatePartial(id, dto));
    }


}
