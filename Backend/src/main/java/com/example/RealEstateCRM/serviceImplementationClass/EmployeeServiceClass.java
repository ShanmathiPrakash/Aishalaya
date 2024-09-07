package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.model.CrmUser;
import com.example.RealEstateCRM.model.Employee;
import com.example.RealEstateCRM.repository.EmployeeRepository;
import com.example.RealEstateCRM.repository.UserRepository;
import com.example.RealEstateCRM.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceClass implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public Employee addEmployee(Employee employee, MultipartFile avatar) {
        // Check if an employee with the same email already exists
        Optional<Employee> existingEmployee = Optional.ofNullable(employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail()));
        if (existingEmployee.isPresent()) {
            throw new IllegalArgumentException("An employee with the email " + employee.getEmployeeEmail() + " already exists.");
        }

        // Process the avatar image if provided
        if (avatar != null) {
            String fileName = saveLogoFile(avatar);
            String newUrl = "/pages/setup/employeeImages/" + fileName;
            employee.setAvatar(newUrl);
        }

        // Set isActive flag based on the input value
        String isActiveValue = employee.getIsActive();
        if ("Active".equalsIgnoreCase(isActiveValue)) {
            employee.setIsActive("1");
        } else if ("Inactive".equalsIgnoreCase(isActiveValue)) {
            employee.setIsActive("0");
        }

        // Generate employee code based on the max employee ID
        Long currentMaxEmployeeId = employeeRepository.findMaxEmployeeId();
        if (currentMaxEmployeeId == null) {
            currentMaxEmployeeId = 0L; // Set default value if null
        }
        employee.generateEmployeeCode(currentMaxEmployeeId);

        // Encrypt password using bcrypt
        String plainPassword = employee.getPassword();
        String encryptedPassword = encryptPassword(plainPassword);
        employee.setPassword(encryptedPassword);

        // Create and save the CRM user
        CrmUser crmUser = new CrmUser();
        crmUser.setCompanyId(employee.getCompany().getCompanyId());
        crmUser.setEmployeeCode(employee.getEmployeeCode());
        crmUser.setEmployeeEmail(employee.getEmployeeEmail());
        crmUser.setUserName(employee.getUserName());
        crmUser.setPassword(encryptedPassword); // Save encrypted password for the user
        userRepository.save(crmUser);

        // Save the employee entity
        return employeeRepository.save(employee);
    }

    private String encryptPassword(String plainPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(plainPassword);
    }
    private String saveLogoFile(MultipartFile avatar) {
        try {
            // Generate unique filename
            String fileName = UUID.randomUUID().toString() + "_" + avatar.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/employeeImages"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName);
            Files.copy(avatar.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }
    private void deleteFile(String fileUrl) {
        File file = new File(fileUrl);
        if (file.exists()) {
            file.delete();
        }
    }
    @Override
    public List<Employee> employeeDetails() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with employeeId: " + employeeId));
    }
    @Override
    public Employee updateEmployee(Long employeeId, Employee employee, MultipartFile avatar) {
        Optional<Employee> ans = employeeRepository.findById(employeeId);
        if (!ans.isPresent()) {
            throw new EntityNotFoundException("Employee not found with ID: " + employeeId);
        }

        Employee employee1 = ans.get();
        System.out.println("EMPLOYEE DETAILS: " + employee1);

        employee1.setCreatedOn(employee.getCreatedOn());
        employee1.setCreatedBy(employee.getCreatedBy());
        employee1.setEmployeeCode(employee.getEmployeeCode());
        employee1.setDob(employee.getDob());
        employee1.setEmployeeName(employee.getEmployeeName());
        employee1.setEmployeeMobile(employee.getEmployeeMobile());
        employee1.setAlterMobile(employee.getAlterMobile());
        employee1.setEmployeeEmail(employee.getEmployeeEmail());
        employee1.setDob(employee.getDob());
        employee1.setGender(employee.getGender());
        employee1.setRole(employee.getRole());
        employee1.getCompany().setCompanyId(employee.getCompany().getCompanyId());
        employee1.setUserName(employee.getUserName());
        employee1.setAddress1(employee.getAddress1());
        employee1.setAddress2(employee.getAddress2());
        employee1.setArea(employee.getArea());
        employee1.setCity(employee.getCity());
        employee1.setDistrict(employee.getDistrict());
        employee1.setState(employee.getState());
        employee1.setPinCode(employee.getPinCode());

        // Encrypt password if it has been changed
        String plainPassword = employee.getPassword();
        if (!plainPassword.equals(employee1.getPassword())) {
            String encryptedPassword = encryptPassword(plainPassword);
            employee1.setPassword(encryptedPassword);
        }

        if (avatar != null) {
            deleteFile(employee1.getAvatar());
            String fileName = saveLogoFile(avatar);
            String logoUrl = "/pages/setup/employeeImages/" + fileName; // Assuming uploads directory for saved logos
            employee1.setAvatar(logoUrl);
        }

        String isActiveValue = employee.getIsActive();
        // Check if the "isActive" field is set to "Active" or "Inactive"
        if ("Active".equalsIgnoreCase(isActiveValue)) {
            employee1.setIsActive("1");
        } else if ("Inactive".equalsIgnoreCase(isActiveValue)) {
            employee1.setIsActive("0");
        }

        return employeeRepository.save(employee1);
    }

    @Override
    public String deleteEmployeeById(Long employeeId) {
        Optional<Employee> myData = employeeRepository.findById(employeeId);
        if (myData.isPresent()) {
            employeeRepository.deleteById(employeeId);
            return "Employee Deleted...Successfully...";
        }
        return "Employee Deletion...Failed...";
    }
    @Override
    public Employee getEmployeeByEmployeeName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);
    }
    @Override
    public Employee getEmployeeByEmail(String employeeEmail) {
        return employeeRepository.findByEmployeeEmail(employeeEmail);
    }

    @Override
    public List<Employee> getEmployeeByCompanyId(Long companyId) {
        List<Employee> employees = employeeRepository.findByCompanyCompanyId(companyId);
        if (employees.isEmpty()) {
            throw new EntityNotFoundException("Employee not found for companyId: " + companyId);
        }
        return employees;
    }


//    @Override
//    public Employee getEmployeeByDesignation(String designation) {
//        return employeeRepository.findByDesignation(designation);
//
//    }
}
