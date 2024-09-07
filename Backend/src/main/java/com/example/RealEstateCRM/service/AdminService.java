package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.Admin;

public interface AdminService {
    Admin adminLogin(String adminName, String password);
    Admin AddAdmin(Admin admin);
}
