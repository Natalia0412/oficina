package com.example.oficina.service.exceptions;

public class ResourceUserNameNotFound extends RuntimeException{
    private static final long serialVersionUID =1l;
    public ResourceUserNameNotFound (String msg) {
        super(msg);
    }
}
