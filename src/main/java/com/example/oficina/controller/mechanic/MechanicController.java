package com.example.oficina.controller.mechanic;

import com.example.oficina.dto.mechanic.MechanicDto;
import com.example.oficina.model.mechanic.Mechanic;
import com.example.oficina.service.mechanic.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mechanics")
public class MechanicController {
    @Autowired
    private MechanicService mechanicService;

    @PostMapping()
    public ResponseEntity<Mechanic> addMechanic(@RequestBody MechanicDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mechanicService.createMechanic(dto));
    }

    @GetMapping()
    public ResponseEntity<List<Mechanic>> getCar(@RequestParam(required = false, defaultValue = "30") int limit, @RequestParam(required = false, defaultValue = "0") int offset) {
        return ResponseEntity.ok(mechanicService.getAll(limit, offset));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mechanic> getMechanicById(@PathVariable String id) {
        return ResponseEntity.ok(mechanicService.getMechanicById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mechanic> updatePartialMechanic(@PathVariable String id, @RequestBody MechanicDto mechanicDto) {
        return ResponseEntity.ok(mechanicService.updatePartial(id, mechanicDto));
    }
}
