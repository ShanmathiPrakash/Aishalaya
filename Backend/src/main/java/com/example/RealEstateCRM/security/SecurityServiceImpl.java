package com.example.RealEstateCRM.security;

import com.example.RealEstateCRM.model.Employee;
import com.example.RealEstateCRM.model.Role;
import com.example.RealEstateCRM.repository.EmployeeRepository;
import com.example.RealEstateCRM.repository.PrivilegeRepository;
import com.example.RealEstateCRM.repository.RolesRepository;
import com.example.RealEstateCRM.service.PrivilegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.management.relation.RoleNotFoundException;
import java.util.*;

@Component
public class SecurityServiceImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    PrivilegesService privilegesService;

    // Method to check if the user has the required privileges dynamically
    public boolean isAccessible(String privilege) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Extract username from token
        String employeeEmail = getUsernameFromAuthentication(authentication);

        // Fetch privileges of the user from the database based on the username
        List<String> activePrivilegeColumnsList = privilegesService.getActivePriviledgeColumnsForMultipleRoles(employeeEmail);

        // Compare the user's privileges
        boolean hasRequiredPrivilege = activePrivilegeColumnsList.contains(privilege);

        return hasRequiredPrivilege;
    }

    private String getUsernameFromAuthentication(Authentication authentication) {
        return authentication.getName();
    }
}