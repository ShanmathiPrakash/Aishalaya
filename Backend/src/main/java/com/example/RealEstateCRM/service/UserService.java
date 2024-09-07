package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.*;

import java.util.List;

public interface UserService {
    CrmUser userLogin(String employeeEmail, String password);

    List<Project> projectDetail();

    Customer customerLogin(String customerEmail, String password);

    Customer getCustomerByEmail(String customerEmail);

    List<ProjectLayout> getProjectLayoutsByProId(Long projectId);

    Company getCompaniesById(Long companyId);
}
