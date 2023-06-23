package com.example.oficina.map.part;

import com.example.oficina.dto.part.PartDto;
import com.example.oficina.model.part.Part;

public class PartMap {
    public static Part partDtoToPart (PartDto dto) {
        Part part = new Part();
        part.setTitle(dto.getTitle());
        part.setDescription(dto.getDescription());
        part.setQtd(dto.getQtd());
        part.setUnitPrice(dto.getUnitPrice());
        return part;
    }






}
