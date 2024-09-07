package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.Driver;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    public Driver createDriver(Driver driver,MultipartFile avatar);
    public Driver editDriver(Long driverId, Driver driver, MultipartFile avatar);
    public Optional<List<Driver>> getDrivers();
    public Driver getDriverById(long driverId);
    public String deleteDriverById(long driverId);
}
