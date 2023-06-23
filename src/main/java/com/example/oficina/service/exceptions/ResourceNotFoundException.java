package com.example.oficina.service.exceptions;

public class ResourceNotFoundException extends  RuntimeException{
    private static final long serialVersionUID =1l;
    public ResourceNotFoundException(String msg, Object id) {
        super(msg + id);
    }
}
