package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    List<Employee> employeeDetails();
    Employee getEmployeeById(Long employeeId);
    Employee updateEmployee(Long employeeId, Employee employee,MultipartFile logoFile);
    String deleteEmployeeById(Long employeeId);
    Employee getEmployeeByEmployeeName(String employeeName);
//    Employee getEmployeeByDesignation(String designation);
    Employee addEmployee(Employee employee, MultipartFile avatar);
    Employee getEmployeeByEmail (String employeeName);


    List<Employee> getEmployeeByCompanyId(Long companyId);
}
