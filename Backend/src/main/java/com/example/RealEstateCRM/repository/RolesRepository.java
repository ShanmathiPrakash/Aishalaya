package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role,Long> {
    public Role findByRole(String roleName);

}
