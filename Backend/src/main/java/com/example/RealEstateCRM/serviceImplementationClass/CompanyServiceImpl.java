package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.model.Company;
import com.example.RealEstateCRM.repository.CompanyModelRepository;
import com.example.RealEstateCRM.service.CompanyService;
import com.example.RealEstateCRM.ExceptionHandling.CompanyNotFoundException;
import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
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
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyModelRepository companyModelRepository;
    public Company saveCompanyDetail(Company company, MultipartFile logoFile, MultipartFile sealFile, MultipartFile signFile) {
        // Check if a company with the same cinNo already exists
        Optional<Company> existingCompany = companyModelRepository.findByCinNo(company.getCinNo());
        if (existingCompany.isPresent()) {
            throw new IllegalArgumentException("A company with the CIN number " + company.getCinNo() + " already exists.");
        }

        // Check if a company with the same companyName already exists
        Optional<Company> existingCompanyName = companyModelRepository.findByCompanyName(company.getCompanyName());
        if (existingCompanyName.isPresent()) {
            throw new IllegalArgumentException("A company with the name " + company.getCompanyName() + " already exists.");
        }

        // Process logo file if provided
        if (logoFile != null) {
            String fileName = saveLogoFile(logoFile);
            String logoUrl = "/pages/setup/companyImages/logoFile/" + fileName; // Assuming uploads directory for saved logos
            company.setLogo(logoUrl);
        }

        // Process signature file if provided
        if (signFile != null) {
            String fileName = saveSignFile(signFile);
            String signUrl = "/pages/setup/companyImages/signFile/" + fileName; // Assuming uploads directory for saved signatures
            company.setSignature(signUrl);
        }

        // Process seal file if provided
        if (sealFile != null) {
            String fileName = saveSealFile(sealFile);
            String sealUrl = "/pages/setup/companyImages/sealFile/" + fileName; // Assuming uploads directory for saved seals
            company.setCompanySeal(sealUrl);
        }

        // Save the company details
        return companyModelRepository.save(company);
    }

    public Company editCompanyDetail(Long companyId, Company company, MultipartFile logoFile, MultipartFile sealFile, MultipartFile signFile) {
        return Optional.ofNullable(companyModelRepository.findBycompanyId(companyId))
                .map(updateCompany -> {
                    updateCompany.setCompanyName(company.getCompanyName());
                    updateCompany.setCompanyShortName(company.getCompanyShortName());
                    updateCompany.setAddress1(company.getAddress1());
                    updateCompany.setAddress2(company.getAddress2());
                    updateCompany.setArea(company.getArea());
                    updateCompany.setDistrict(company.getDistrict());
                    updateCompany.setStateCode(company.getStateCode());
                    updateCompany.setGstNo(company.getGstNo());
                    updateCompany.setCinNo(company.getCinNo());
                    updateCompany.setPincode(company.getPincode());
                    updateCompany.setContact(company.getContact());
                    updateCompany.setPhone(company.getPhone());
                    updateCompany.setMobile(company.getMobile());
                    updateCompany.setEmail(company.getEmail());
                    // Delete old logo if new logo is uploaded
                    if (logoFile != null) {
                        deleteFile(updateCompany.getLogo());
                        String fileName = saveLogoFile(logoFile);
                        String logoUrl ="/pages/setup/companyImages/logoFile/"+fileName; // Assuming uploads directory for saved logos
                        updateCompany.setLogo(logoUrl);
                    }
                    // Delete old sign if new sign is uploaded
                    if (signFile != null) {
                        deleteFile(updateCompany.getSignature());
                        String fileName = saveSignFile(signFile);
                        String signUrl = "/pages/setup/companyImages/signFile/"+fileName;// Assuming uploads directory for saved signs
                        updateCompany.setSignature(signUrl);
                    }
                    // Delete old seal if new seal is uploaded
                    if (sealFile != null) {
                        deleteFile(updateCompany.getCompanySeal());
                        String fileName = saveSealFile(sealFile);
                        String sealUrl = "/pages/setup/companyImages/sealFile/"+fileName; // Assuming uploads directory for saved seals
                        updateCompany.setCompanySeal(sealUrl);
                    }
                    updateCompany.setSalesMail(company.getSalesMail());
                    updateCompany.setPanNo(company.getPanNo());
                    updateCompany.setBankName(company.getBankName());
                    updateCompany.setAccNo(company.getAccNo());
                    updateCompany.setBranchName(company.getBranchName());
                    updateCompany.setIfscCode(company.getIfscCode());
                    updateCompany.setUpiId(company.getUpiId());
                    updateCompany.setUpiNumber(company.getUpiNumber());

                    return companyModelRepository.save(updateCompany);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));
    }
    private void deleteFile(String fileUrl) {
        File file = new File(fileUrl);
        if (file.exists()) {
            file.delete();
        }
    }
    private String saveLogoFile(MultipartFile logoFile) {
        try {
            // Generate unique filename
            String fileName = UUID.randomUUID().toString() + "_" + logoFile.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/companyImages/logoFile"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName);
            Files.copy(logoFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }
    private String saveSignFile(MultipartFile signFile) {
        try {
            // Generate unique filename
            // String fileName = UUID.randomUUID().toString() + "_" + signFile.getOriginalFilename();
            String fileName = signFile.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/companyImages/signFile";// Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName);
            Files.copy(signFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }
    private String saveSealFile(MultipartFile sealFile) {
        try {
            // Generate unique filename
            String fileName = UUID.randomUUID().toString() + "_" + sealFile.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/companyImages/sealFile"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName);
            Files.copy(sealFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }
    @Override
    public Optional<List<Company>> getAllCompany() {
        Optional<List<Company>> companyOptional= Optional.ofNullable(companyModelRepository.findAll());

        return companyOptional;
    }
    @Override
    public Company getCompanyById(Long companyId) {
        Optional<Company> companyOptional = companyModelRepository.findById(companyId);
        if (companyOptional.isPresent()) {
            return companyOptional.get();
        } else {
            // Handle the case where company is not found, maybe throw an exception or return null
            throw new CompanyNotFoundException("Company is not found");
        }
    }
    @Override
    public String deleteById(long companyId) {
        Optional<Company> companyOptional = companyModelRepository.findById(companyId);

        if (companyOptional.isPresent()) {
            // Company found, proceed with deletion logic
            companyModelRepository.deleteById(companyId);
            return "Company deleted successfully";
        } else {
            // Company not found, throw an exception
            throw new CompanyNotFoundException("Company with ID " + companyId + " not found");
        }
    }

    @Override
    public Company getCompanyIdByCompanyName(String companyName) {
        Optional<Company> companyOptional = companyModelRepository.findByCompanyName(companyName);
        if (companyOptional.isPresent()) {
            return companyOptional.get();
        } else {
            // Handle the case where company is not found, maybe throw an exception or return null
            throw new CompanyNotFoundException("Company is not found");
        }
    }
}
