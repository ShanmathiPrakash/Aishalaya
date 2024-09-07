package com.example.RealEstateCRM.ExceptionHandling;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {super(message);}
}

