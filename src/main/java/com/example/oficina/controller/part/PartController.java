package com.example.oficina.controller.part;

import com.example.oficina.dto.part.PartDto;
import com.example.oficina.model.part.Part;
import com.example.oficina.service.part.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parts")
public class PartController {
    @Autowired
    private PartService partService;

    @PostMapping()
    public ResponseEntity<Part> addPart(@RequestBody PartDto partDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(partService.createPart(partDto));
    }

    @GetMapping()
    public ResponseEntity<List<Part>> getCar(@RequestParam(required = false, defaultValue = "30") int limit, @RequestParam(required = false, defaultValue = "0") int offset) {
        return ResponseEntity.ok(partService.getAll(limit, offset));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Part> getPartById(@PathVariable String id) {
        return ResponseEntity.ok(partService.getByIdPart(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Part> updatePartilPart(@PathVariable String id, @RequestBody PartDto partDto) {
        return ResponseEntity.ok(partService.updatePartialPart(id, partDto));
    }
}
