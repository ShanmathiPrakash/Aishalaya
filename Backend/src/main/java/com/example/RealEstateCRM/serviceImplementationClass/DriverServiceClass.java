package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
import com.example.RealEstateCRM.model.Driver;

import com.example.RealEstateCRM.repository.DriverRepository;
import com.example.RealEstateCRM.service.DriverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceClass implements DriverService {
    @Autowired
    DriverRepository driverRepository;
    @Override
    public Driver createDriver(Driver driver,MultipartFile avatar) {
        if ("active".equalsIgnoreCase(driver.getIsActive())) {
            driver.setIsActive("1");
        } else if ("inactive".equalsIgnoreCase(driver.getIsActive())) {
            driver.setIsActive("0");
        } else {
            // Throw an exception or handle invalid status here
            throw new IllegalArgumentException("Invalid status: " + driver.getIsActive());
        }
        if (avatar != null) {
            String fileName = saveAvatarFile(avatar);
            String avatarUrl = "avatarDriver/" + fileName;
            driver.setAvatar(avatarUrl);
        }

        return driverRepository.save(driver);
    }
    @Override
    public Driver editDriver(Long driverId, Driver driver, MultipartFile avatar) {
        Optional<Driver> driverOptional = Optional.ofNullable(driverRepository.findByDriverId(driverId));
        if (driverOptional.isPresent()) {
            Driver existingDriver = driverOptional.get();
            existingDriver.setEmployeeCode(driver.getEmployeeCode());
            existingDriver.setEmployeeName(driver.getEmployeeName());
            existingDriver.setDepartment(driver.getDepartment());
            existingDriver.setEmployeeMobile(driver.getEmployeeMobile());
            existingDriver.setAlterMobile(driver.getAlterMobile());
            existingDriver.setEmployeeEmail(driver.getEmployeeEmail());
            existingDriver.setAddress1(driver.getAddress1());
            existingDriver.setAddress2(driver.getAddress2());
            existingDriver.setArea(driver.getArea());
            existingDriver.setCity(driver.getCity());
            existingDriver.setDistrict(driver.getDistrict());
            existingDriver.setState(driver.getState());
            existingDriver.setPincode(driver.getPincode());
            if ("active".equalsIgnoreCase(driver.getIsActive())) {
                existingDriver.setIsActive("1");
            } else if ("inactive".equalsIgnoreCase(driver.getIsActive())) {
                existingDriver.setIsActive("0");
            } else {
                // Throw an exception or handle invalid status here
                throw new IllegalArgumentException("Invalid status: " + driver.getIsActive());
            }

            if (avatar != null) {
                deleteFile(existingDriver.getAvatar());
                String fileName = saveAvatarFile(avatar);
                String avatarUrl = "avatarDriver/" + fileName;
                existingDriver.setAvatar(avatarUrl);
            }

            // Save the updated driver entity
            return driverRepository.save(existingDriver);
        } else {
            throw new ResourceNotFoundException("Driver with ID: " + driverId + " not found");
        }
    }
    private String saveAvatarFile(MultipartFile sign) {
        try {
            // Generate unique filename
            String fileName = sign.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "alldocuments/avatarDriver/"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName);
            Files.copy(sign.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }
    private void deleteFile(String fileUrl) {
        File file = new File(fileUrl);
        if (file.exists()) {
            file.delete();
        }
    }
    public Optional<List<Driver>> getDrivers(){
        return Optional.ofNullable(driverRepository.findAll());
    }
    public Driver getDriverById(long driverId){
        Optional<Driver> driverOptional= Optional.ofNullable(driverRepository.findByDriverId(driverId));
        Driver driver;
        if(driverOptional.isEmpty()) {
            throw new ResourceNotFoundException("Driver with ID: " + driverId + " not found");
        }
            else
            driver = driverOptional.get();
            return driver;
    }
    public String deleteDriverById(long driverId){
        Optional<Driver> driverOptional = driverRepository.findById(driverId);

        if (driverOptional.isPresent()) {
            driverRepository.deleteById(driverId);
            return "Driver deleted successfully";
        } else {
            throw new ResourceNotFoundException("Driver with ID " + driverId + " not found");
        }
    }
}
