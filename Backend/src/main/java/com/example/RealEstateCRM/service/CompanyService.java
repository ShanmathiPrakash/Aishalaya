package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.Company;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;

public interface CompanyService {

    public Company saveCompanyDetail(Company company, MultipartFile logoFile, MultipartFile sealFile, MultipartFile signFile);
    public Company editCompanyDetail(Long companyId, Company company, MultipartFile logoFile, MultipartFile sealFile, MultipartFile signFile);
    public Optional<List<Company>> getAllCompany();
    public Company getCompanyById(Long companyId);
    public String deleteById(long companyId);

    Company getCompanyIdByCompanyName(String companyName);
}
