package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    public Role generateCompany(Role role);
    Optional<List<Role>> getAllRole();
}
