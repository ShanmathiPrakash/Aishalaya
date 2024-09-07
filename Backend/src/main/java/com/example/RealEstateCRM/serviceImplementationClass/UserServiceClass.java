package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.ExceptionHandling.CompanyNotFoundException;
import com.example.RealEstateCRM.model.*;
import com.example.RealEstateCRM.repository.*;
import com.example.RealEstateCRM.service.UserService;
import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceClass implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public CrmUser userLogin(String employeeEmail, String password) {
        CrmUser user = userRepository.findByEmployeeEmail(employeeEmail);

        // Check if the user exists
        if (user == null) {
            throw new EntityNotFoundException("User not found with emailId: " + employeeEmail);
        }

        // Check if the password matches (consider using a secure password hashing mechanism)
        if (!user.getPassword().equals(password)) {
            throw new ResourceNotFoundException("Incorrect password for user with emailId: " + employeeEmail);
        }
        return user;
    }


    @Autowired
    ProjectRepository projectRepository;
    @Override
    public List<Project> projectDetail() {
        return projectRepository.findAll();
    }


    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer customerLogin(String customerEmail, String password) {
        Customer customer = customerRepository.findByCustomerEmail(customerEmail);

        // Check if the user exists
        if (customer == null) {
            throw new EntityNotFoundException("Adminn not found with emailId: " + customerEmail);
        }
        // Check if the password matches (consider using a secure password hashing mechanism)
        if (!customer.getPassword().equals(password)) {
            throw new ResourceNotFoundException("Incorrect password for user with AdminName: " + customerEmail);
        }
        return customer;
    }

    @Override
    public Customer getCustomerByEmail(String customerEmail) {
        return customerRepository.findByCustomerEmail(customerEmail);
    }

    @Autowired
    ProjectLayoutRepository projectLayoutRepository;

    @Override
    public List<ProjectLayout> getProjectLayoutsByProId(Long projectId) {
        return projectLayoutRepository.findByProjectId(projectId);
    }

    @Autowired
    CompanyModelRepository companyModelRepository;

    @Override
    public Company getCompaniesById(Long companyId) {
        Optional<Company> companyOptional = companyModelRepository.findById(companyId);
        if (companyOptional.isPresent()) {
            return companyOptional.get();
        } else {
            // Handle the case where company is not found, maybe throw an exception or return null
            throw new CompanyNotFoundException("Company is not found");
        }
    }
}
