package com.example.RealEstateCRM.security;

import com.example.RealEstateCRM.model.Employee;
import com.example.RealEstateCRM.model.Role;
import com.example.RealEstateCRM.repository.EmployeeRepository;
import com.example.RealEstateCRM.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //allows spring container to create new instance or bean every time unlike singleton scope
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("Entering in loadUserByUsername Method...");
        Employee employee = employeeRepository.findByEmployeeEmail(username);
        if (employee == null) {
            logger.error("Username not found: " + username);
            throw new UsernameNotFoundException("Could not find user..!!");
        }

        logger.info("User Authenticated Successfully..!!!");

        List<GrantedAuthority> auths = new ArrayList<>();

        // Initialize teamId and userId
        List<Long> teamIds = employee.getTeamId() != null ? employee.getTeamId() : new ArrayList<>();
        Long userId = employee.getUserId();

        for (Long teamId : teamIds) {
            auths.add(new SimpleGrantedAuthority("TEAM_" + teamId));
        }
        if (userId != null) {
            auths.add(new SimpleGrantedAuthority("USER_" + userId));
        }
        return new org.springframework.security.core.userdetails.User(employee.getEmployeeEmail(), employee.getPassword(), auths);
    }
}