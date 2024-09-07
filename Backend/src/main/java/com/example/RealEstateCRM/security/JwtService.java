package com.example.RealEstateCRM.security;

import com.example.RealEstateCRM.model.Employee;

import com.example.RealEstateCRM.repository.EmployeeRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;

import java.util.*;
import java.util.function.Function;
@Component
public class JwtService {
    private final SecretKey jwtSecret = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private long jwtExpirationTime = 31536000000L; // 1 year

    @Autowired
    EmployeeRepository employeeRepository;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(String employeeEmail) {
        Map<String, Object> claims = new HashMap<>();
        Employee employee = employeeRepository.findByEmployeeEmail(employeeEmail);
        if (employee != null && "1".equals(employee.getIsActive())) {
            List<GrantedAuthority> auths = new ArrayList<>();

            // Initialize teamId and userId
            List<Long> teamIds = employee.getTeamId() != null ? employee.getTeamId() : new ArrayList<>();
            String userId = employee.getUserId() != null ? employee.getUserId().toString() : null;

            for (Long teamId : teamIds) {
                auths.add(new SimpleGrantedAuthority("TEAM_" + teamId));
            }
            if (userId != null) {
                auths.add(new SimpleGrantedAuthority("USER_" + userId));
            }


            claims.put("authorities", auths);
            return createToken(claims, employeeEmail);
        }
        // Return a custom string indicating inactive employee
        return "INACTIVE_EMPLOYEE";
    }
    private String createToken(Map<String, Object> claims, String username) {
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + jwtExpirationTime);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expiryDate)
                .signWith(jwtSecret, SignatureAlgorithm.HS256)
                .compact();
    }
}