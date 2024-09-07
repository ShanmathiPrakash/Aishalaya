//package com.example.RealEstateCRM.security;
//
//import com.example.RealEstateCRM.model.Employee;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.io.IOException;
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtService JwtService;
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JwtService JwtService) {
//        this.authenticationManager = authenticationManager;
//        this.JwtService = JwtService;
//        setFilterProcessesUrl("/api/v1/login");
//    }
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        /*
//        * request body be like:
//        * {
//        * "employeeEmail":"abc@gmail.com,
//        * "password": "abc123"
//        * }
//        * */
//
//        try {
//            System.out.println("Attempting Authentication......");
//            Employee employee = new ObjectMapper().readValue(request.getInputStream(), Employee.class); //entity class User
//            System.out.println("UserDetails "+employee);
//            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employee.getEmployeeEmail(), employee.getPassword()));
//        }
//        catch (IOException e){
//            throw new RuntimeException("Could not request: "+ e);
//
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws  IOException, ServletException {
//        String username =((org.springframework.security.core.userdetails.User) authResult.getPrincipal()).getUsername();
//        System.out.println("Generating Token....");
//        String token = JwtService.GenerateToken(username);
//        System.out.println("Generated Token : " + token);
//        response.addHeader(JWTConstants.HEADER_STRING, JWTConstants.TOKEN_PREFIX + token);
//    }
//}
