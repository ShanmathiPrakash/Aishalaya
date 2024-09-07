package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.model.Customer;
import com.example.RealEstateCRM.repository.CustomerRepository;
import com.example.RealEstateCRM.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomerServiceClass implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer, MultipartFile image) {
        // Check if a customer with the same mobile number already exists
        Optional<Customer> existingCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (existingCustomer.isPresent()) {
            throw new IllegalArgumentException("A customer with the mobile number " + customer.getMobileNumber() + " already exists.");
        }

        // Process image file if provided
        if (image != null) {
            String fileName = saveLogoFile(image);
            String logoUrl = "/pages/setup/customerImages/" + fileName; // Assuming uploads directory for saved images
            customer.setImage(logoUrl);
        }

        // Generate customer code based on the max customer ID
        Long currentMaxCustomerId = customerRepository.findMaxCustomerId();
        if (currentMaxCustomerId == null) {
            currentMaxCustomerId = 0L; // Set default value if null
        }
        customer.generateEmployeeCode(currentMaxCustomerId);

        // Save the customer entity
        return customerRepository.save(customer);
    }


    @Override
    public List<Customer> customerDetails() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer, MultipartFile image) {
        Optional<Customer> ans=customerRepository.findById(customerId);
        Customer customer1=ans.get();
        customer1.setDate(customer.getDate());
        customer1.setCustomerName(customer.getCustomerName());
        customer1.setEmployeeCode(customer.getEmployeeCode());
        customer1.setMobileNumber(customer.getMobileNumber());
        customer1.setLocation(customer.getLocation());
        customer1.setAddress(customer.getAddress());
        customer1.setCustomerName(customer.getCustomerName());
        customer1.setPassword(customer.getPassword());
        customer1.setEmployeeType(customer.getEmployeeType());
        customer1.setWorkPlace(customer.getWorkPlace());
        customer1.setCompanyId(customer.getCompanyId());
        if (image!= null) {
            deleteFile(customer1.getImage());
            String fileName = saveLogoFile(image);
            String logoUrl = "/pages/setup/customerImages/" + fileName; // Assuming uploads directory for saved logos
            customer1.setImage(logoUrl);
        }
        return customerRepository.save(customer1);
    }

    @Override
    public String deleteCustomerById(Long customerId) {
        Optional<Customer> myData = customerRepository.findById(customerId);
        if (myData.isPresent()) {
            customerRepository.deleteById(customerId);
            return "Customer Deleted...Successfully...";
        }
        return "Customer Deletion...Failed...";
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with customerId: " + customerId));
    }

    @Override
    public Customer getCustomer(String customerName, String mobileNumber, String employeeCode) {
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerNameAndMobileNumberAndEmployeeCode(customerName, mobileNumber, employeeCode);

        // Check if customer exists and return it, or throw an exception if not found
        return optionalCustomer.orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    private String saveLogoFile(MultipartFile image) {
        try {
            // Generate unique filename
            String fileName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/customerImages";// Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName);
            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
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
    public Customer getCustomerByPhoneNumber(String mobileNumber) {
        Optional<Customer> customer = customerRepository.findByMobileNumber(mobileNumber);
        return customer.orElse(null); // Returns null if no customer is found
//        return customerRepository.findByMobileNumber(mobileNumber)
//                .orElseThrow(() -> new EntityNotFoundException("Customer not found with customerMobileNo: " + mobileNumber));
    }

    @Override
    public List<Customer> getCustomerByCompanyId(Long companyId) {
        List<Customer> customers = customerRepository.findByCompanyId(companyId);
        if (customers.isEmpty()) {
            throw new EntityNotFoundException("Customer not found for companyId: " + companyId);
        }
        return customers;
    }

    @Override
    public List<Customer> getCustomerByCompanyIdAndTeamId(Long companyId, List<Long> teamId) {
        return customerRepository.findByCompanyIdAndTeamIdIn(companyId, teamId);
    }
}
