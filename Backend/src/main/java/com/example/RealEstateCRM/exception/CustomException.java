package com.example.RealEstateCRM.exception;

public class CustomException {
    public static class displayError extends RuntimeException{
        public displayError(String message) {
            super(message);
        }
    }
}
