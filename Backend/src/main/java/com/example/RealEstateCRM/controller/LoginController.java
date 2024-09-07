package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.dto.AuthRequestDTO;

import com.example.RealEstateCRM.security.JWTConstants;
import com.example.RealEstateCRM.security.JwtService;
import com.example.RealEstateCRM.security.SecurityServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class LoginController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityServiceImpl securityServiceImpl;

   @PostMapping("/login")
    public ResponseEntity<?> AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));

        if(authentication.isAuthenticated()){
            String token = jwtService.generateToken(authRequestDTO.getUsername());
            System.out.println("Generated Token : " + token);
            HttpHeaders headers = new HttpHeaders();
            headers.add(JWTConstants.HEADER_STRING, JWTConstants.TOKEN_PREFIX+ token);

            return ResponseEntity.ok().headers(headers).build();
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }

    //FOR TESTING PURPOSE
    @PreAuthorize("@securityServiceImpl.isAccessible('setUp')")
    @GetMapping("/setUp/public/ping")
    public String pingtest() throws RoleNotFoundException {
        System.out.println("securityServiceImpl.isAccessible(): "+securityServiceImpl.isAccessible("setUp"));
            return "ping Successfully";
    }
}
