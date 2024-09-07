package com.example.RealEstateCRM.controller;


import com.example.RealEstateCRM.model.Company;
import com.example.RealEstateCRM.model.Customer;
import com.example.RealEstateCRM.model.Project;
import com.example.RealEstateCRM.model.ProjectLayout;
import com.example.RealEstateCRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/getAllProjectDetail")
    public ResponseEntity<List<Project>> getAllProjectDetail() {
        List<Project> projects = userService.projectDetail();
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/customerLogin")
    public ResponseEntity<Customer> customerLogin(@RequestBody Customer customer) {
        {
            // Assuming userService has a method to verify login credentials
            Customer customer1 = userService.customerLogin(customer.getCustomerEmail(), customer.getPassword());

            // Adjust the response based on your requirements
            return ResponseEntity.ok(customer1);
        }
    }

    @GetMapping("/getCustomerByEmail/{customerEmail}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerEmail) {
        Customer customer = userService.getCustomerByEmail(customerEmail);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/getProjectLayoutsByProId/{projectId}")
    public ResponseEntity<List<ProjectLayout>> getProjectLayoutsByProId(@PathVariable Long projectId) {
        List<ProjectLayout> projectLayout = userService.getProjectLayoutsByProId(projectId);
        return ResponseEntity.ok(projectLayout);
    }

    @GetMapping("/getCompaniesById/{companyId}")
    public ResponseEntity<Company> getCompaniesById(@PathVariable Long companyId) {
        return new ResponseEntity<>(userService.getCompaniesById(companyId), HttpStatus.OK);
    }

}
