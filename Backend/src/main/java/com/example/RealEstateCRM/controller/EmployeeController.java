package com.example.RealEstateCRM.controller;

//import com.example.RealEstateCRM.model.Employee;
//import com.example.RealEstateCRM.model.Employee;
//import com.example.RealEstateCRM.service.EmployeeService;
////import org.hibernate.mapping.List;
//import org.hibernate.mapping.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import java.util.List;

import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.model.Employee;
import com.example.RealEstateCRM.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5500", "http://localhost:5000"})
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
//    @PreAuthorize("@securityServiceImpl.isAccessible('setUp')")
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestPart("employee") Employee employee,
                                                @RequestPart("avatar") MultipartFile avatar){
        return new ResponseEntity<>(employeeService.addEmployee(employee,avatar), HttpStatus.CREATED);
    }
//    @PreAuthorize("@securityServiceImpl.isAccessible('setUp')")
    @GetMapping("/getAllEmployeeDetails")
    public ResponseEntity<List<Employee>> employeeDetails() {
        List<Employee> employee = employeeService.employeeDetails();
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/getEmployeeById/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/getEmployeeByEmployeeName/{employeeName}")
    public ResponseEntity<Employee> getEmployeeByEmployeeName(@PathVariable String employeeName) {
        Employee employee = employeeService.getEmployeeByEmployeeName(employeeName);
        return ResponseEntity.ok(employee);
    }
    @GetMapping("/getEmployeeByEmail/{employeeEmail}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeEmail)
    {
        Employee employee = employeeService.getEmployeeByEmail(employeeEmail);
        return ResponseEntity.ok(employee);
    }
//    @GetMapping("/getEmployeeByDesignation/{designation}")
//    public ResponseEntity<Employee> getEmployeeByDesignation(@PathVariable String designation) {
//        Employee employee = employeeService.getEmployeeByDesignation(designation);
//        return ResponseEntity.ok(employee);
//    }
    @PutMapping("/updateEmployee/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId,
                                               @RequestPart("employee") Employee employee,
                                               @RequestPart(value = "logoFile", required = false) MultipartFile logoFile) {
        System.out.println("Details from FormData for employee details update : employeeId : "+employeeId+"\n"+"employee :"+employee);
        return new ResponseEntity<>(employeeService.updateEmployee(employeeId, employee,logoFile), HttpStatus.OK);
    }
    @DeleteMapping("/deleteEmployeeById/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long employeeId) {
        return new ResponseEntity<String>(employeeService.deleteEmployeeById(employeeId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getEmployeeByCompanyId/{companyId}")
    public ResponseEntity<List<Employee>> getEmployeeByCompanyId(@PathVariable Long companyId) {
        List<Employee> employees = employeeService.getEmployeeByCompanyId(companyId);
        return ResponseEntity.ok(employees);
    }


}
