package com.example.RealEstateCRM.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(VisitDetailNotFoundException.class)
    public ResponseEntity<String> handleUserDefinedException(VisitDetailNotFoundException ex){
        String errorMessage= ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<String> handleUserDefinedException(CompanyNotFoundException ex){
        String errorMessage= ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleUserDefinedException(ResourceNotFoundException ex){
        String errorMessage= ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
