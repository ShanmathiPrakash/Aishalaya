package com.example.RealEstateCRM.controller;


import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
import com.example.RealEstateCRM.model.Privilege;
import com.example.RealEstateCRM.service.PrivilegesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/privilege")
public class PrivilegeController {

    @Autowired
    PrivilegesService privilegesService;


    @PostMapping("/addPrivilege")
    public ResponseEntity<Privilege> addPrivilege(@RequestBody Privilege privilege)
    {
        Privilege savedPrivilege = privilegesService.generatePrivilege(privilege);
        return new ResponseEntity<>(savedPrivilege, HttpStatus.CREATED);
    }

    @GetMapping("/getActivePrivileges/{emailId}")
    public ResponseEntity<List<String>> comparePrivilege(@PathVariable String emailId) {
        try {
            List<String> privilege =  privilegesService.getActivePriviledgeColumnsForMultipleRoles(emailId);
            return ResponseEntity.ok(privilege);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }




}
