package com.example.RealEstateCRM.ExceptionHandling;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(String message){
        super(message);
    }
}
