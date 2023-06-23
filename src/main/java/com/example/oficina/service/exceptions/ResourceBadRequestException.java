package com.example.oficina.service.exceptions;

public class ResourceBadRequestException extends RuntimeException{
    private static final long serialVersionUID =1l;
    public ResourceBadRequestException(String msg) {
        super(msg);
    }
}
