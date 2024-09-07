package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.Driver;
import com.example.RealEstateCRM.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/driver")
public class DriverController {
    @Autowired
    DriverService driverService;
    @PostMapping("/DriverCreation")
    public ResponseEntity<com.example.RealEstateCRM.model.Driver> generateDriver(@RequestPart("driver") Driver driver, @RequestPart("avatar") MultipartFile avatar) {
        return new ResponseEntity<>(driverService.createDriver(driver,avatar), HttpStatus.CREATED);
    }
    @PutMapping("/driverEditById/{driverId}")
    public ResponseEntity<Driver> editDriver(@PathVariable Long driverId, @RequestPart("driver") Driver driver, @RequestPart(value = "avatar", required = false) MultipartFile avatar) {
        return new ResponseEntity<>(driverService.editDriver(driverId,driver,avatar), HttpStatus.OK);
    }
    @GetMapping("getDriver")
    public ResponseEntity<Optional<List<Driver>>> getAllDrivers(){
        return new ResponseEntity<>(driverService.getDrivers(),HttpStatus.OK);
    }
    @GetMapping("getDriverByName/{driverId}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long driverId) {
        return new ResponseEntity<>(driverService.getDriverById(driverId),HttpStatus.OK);
    }
    @DeleteMapping("/deleteDriver/{driverId}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable long driverId){
        return new ResponseEntity<>(driverService.deleteDriverById(driverId),HttpStatus.NOT_FOUND);
    }
}
