package com.example.RealEstateCRM.security;

import com.example.RealEstateCRM.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends Employee implements UserDetails {

    private String username;
    private String password;
    Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Employee employee) {
        this.username = employee.getEmployeeEmail();
        this.password = employee.getPassword();
        List<GrantedAuthority> auths = new ArrayList<>();

        // Ensure teamId and userId are initialized
        List<Long> teamIds = employee.getTeamId() != null ? employee.getTeamId() : new ArrayList<>();
        String userId = employee.getUserId() != null ? employee.getUserId().toString() : null;

        for (Long teamId : teamIds) {
            auths.add(new SimpleGrantedAuthority("TEAM_" + teamId));
        }
        if (userId != null) {
            auths.add(new SimpleGrantedAuthority("USER_" + userId));
        }


        this.authorities = auths;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
