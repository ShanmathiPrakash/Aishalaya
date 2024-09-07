package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByAdminName(String adminName);
}
