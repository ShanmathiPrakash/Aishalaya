package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.model.Role;
import com.example.RealEstateCRM.repository.RolesRepository;
import com.example.RealEstateCRM.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceClass implements RoleService {

    @Autowired
    RolesRepository rolesRepository;


    @Override
    public Role generateCompany(Role role) {
        return rolesRepository.save(role);
    }

    @Override
    public Optional<List<Role>> getAllRole() {
        Optional<List<Role>> roleOptional= Optional.ofNullable(rolesRepository.findAll());

        return roleOptional;
    }
}
