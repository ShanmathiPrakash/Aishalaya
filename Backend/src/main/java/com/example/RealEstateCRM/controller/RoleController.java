package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.Role;
import com.example.RealEstateCRM.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/addRole")
    public ResponseEntity<Role> addEmployee(@RequestBody  Role role){
        return new ResponseEntity<>(roleService.generateCompany(role), HttpStatus.CREATED);
    }
    @GetMapping("/getRoles")
    public ResponseEntity<Optional<List<Role>>> getAllRoles() {
        Optional<List<Role>> role = roleService.getAllRole();
        return ResponseEntity.ok(role);
    }
}
