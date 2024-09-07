package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.CrmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CrmUser,Long > {
    CrmUser findByEmployeeEmail(String employeeEmail);
}
