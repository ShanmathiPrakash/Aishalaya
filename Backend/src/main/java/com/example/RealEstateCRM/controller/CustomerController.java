package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.model.Customer;
import com.example.RealEstateCRM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestPart("customer") Customer customer,
                                                @RequestPart("image") MultipartFile image){
        return new ResponseEntity<>(customerService.addCustomer(customer,image), HttpStatus.CREATED);
    }
    @GetMapping("/getAllCustomerDetails")
    public ResponseEntity<List<Customer>> customerDetails() {
        List<Customer> customer = customerService.customerDetails();
        return ResponseEntity.ok(customer);
    }
    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/getCustomer/{customerName}/{mobileNumber}/{employeeCode}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerName,@PathVariable String mobileNumber,@PathVariable String employeeCode) {
        Customer customer = customerService.getCustomer(customerName,mobileNumber,employeeCode);
        return ResponseEntity.ok(customer);
    }
    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId,
                                                   @RequestPart("customer") Customer customer,
                                                   @RequestPart(value = "image", required = false) MultipartFile image) {
        return new ResponseEntity<>(customerService.updateCustomer(customerId,customer,image), HttpStatus.OK);
    }
    @DeleteMapping("/deleteCustomerById/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long customerId) {
        return new ResponseEntity<String>(customerService.deleteCustomerById(customerId), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getCustomerByPhoneNumber/{mobileNumber}")
    public ResponseEntity<Customer> getCustomerByPhoneNumber(@PathVariable String mobileNumber) {
        Customer customer = customerService.getCustomerByPhoneNumber(mobileNumber);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/getCustomerByCompanyId/{companyId}")
    public ResponseEntity<List<Customer>> getCustomerByCompanyId(@PathVariable Long companyId) {
        List<Customer> customers = customerService.getCustomerByCompanyId(companyId);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/companyAndTeamId/{companyId}/{teamId}")
    public List<Customer> getCustomerByCompanyAndTeam(@PathVariable Long companyId, @PathVariable List<Long> teamId)
    {
        return customerService.getCustomerByCompanyIdAndTeamId(companyId, teamId);
    }
}
