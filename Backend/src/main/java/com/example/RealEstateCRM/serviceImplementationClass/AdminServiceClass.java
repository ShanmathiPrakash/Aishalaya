package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.model.Admin;
import com.example.RealEstateCRM.repository.AdminRepository;
import com.example.RealEstateCRM.service.AdminService;
import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceClass implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Admin adminLogin(String adminName, String password) {
        Admin admin = adminRepository.findByAdminName(adminName);

        // Check if the user exists
        if (adminName == null) {
            throw new EntityNotFoundException("Adminn not found with emailId: " + adminName);
        }
        // Check if the password matches (consider using a secure password hashing mechanism)
        if (!admin.getPassword().equals(password)) {
            throw new ResourceNotFoundException("Incorrect password for user with AdminName: " + adminName);
        }
        return admin;
    }
    @Override
    public Admin AddAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
