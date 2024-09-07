package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.Admin;
import com.example.RealEstateCRM.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/localAdmin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/AddAdmin")
    public ResponseEntity<Admin> AddAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<Admin>(adminService.AddAdmin(admin), HttpStatus.ACCEPTED);
    }
}
