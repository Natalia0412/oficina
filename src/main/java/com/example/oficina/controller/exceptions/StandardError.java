package com.example.oficina.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID =1l;
    private Instant timestamp;
    private Integer status;
    private String Error;
    private String message;
    private String path;
}
