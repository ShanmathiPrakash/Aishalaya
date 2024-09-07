package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer, MultipartFile image);
    List<Customer> customerDetails();
    Customer updateCustomer(Long customerId, Customer customer, MultipartFile image);
    String deleteCustomerById(Long customerId);
    Customer getCustomerById(Long customerId);

    Customer getCustomer(String customerName, String mobileNumber, String employeeCode);
    Customer getCustomerByPhoneNumber(String mobileNumber);

    List<Customer> getCustomerByCompanyId(Long companyId);

    List<Customer> getCustomerByCompanyIdAndTeamId(Long companyId, List<Long> teamId);
}
