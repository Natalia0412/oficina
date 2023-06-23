package com.example.oficina.controller.exceptions;


import com.example.oficina.service.exceptions.ResourceBadRequestException;
import com.example.oficina.service.exceptions.ResourceIlegalArgumentException;
import com.example.oficina.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<StandardError> resourceDuplicated(ResourceBadRequestException e, HttpServletRequest request) {
        String error = "Bad Request ";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceIlegalArgumentException.class)
    public ResponseEntity<StandardError> resourceIlegalArgument(ResourceIlegalArgumentException e, HttpServletRequest request) {
        String error = "One or more Id does not exist";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity
                .status(status)
                .body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err1 = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity
                .status(status)
                .body(err1);
    }
}
