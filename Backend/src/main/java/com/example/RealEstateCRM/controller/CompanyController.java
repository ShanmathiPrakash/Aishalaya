package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.Company;
import com.example.RealEstateCRM.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @PostMapping("/createCompany")
    public ResponseEntity<Company> createCompany(@RequestPart("company") Company company,
                                                 @RequestPart("logoFile") MultipartFile logoFile,
                                                 @RequestPart("sealFile") MultipartFile sealFile,
                                                 @RequestPart("signFile") MultipartFile signFile){
        return new ResponseEntity<>(companyService.saveCompanyDetail(company,logoFile,sealFile,signFile), HttpStatus.CREATED);
    }
    @PutMapping("/editCompany/{companyId}")
    public ResponseEntity<Company> editCompany(@PathVariable Long companyId,
                                               @RequestPart("company") Company company,
                                               @RequestPart(value = "logoFile", required = false) MultipartFile logoFile,
                                               @RequestPart(value = "sealFile", required = false) MultipartFile sealFile,
                                               @RequestPart(value = "signFile", required = false) MultipartFile signFile) {
        return new ResponseEntity<>(companyService.editCompanyDetail(companyId, company,logoFile,sealFile,signFile), HttpStatus.OK);
    }
    @GetMapping("/getCompany")
    public ResponseEntity<Optional<List<Company>>> getAllCompany() {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }
    @GetMapping("/getCompanyById/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        return new ResponseEntity<>(companyService.getCompanyById(companyId), HttpStatus.OK);
    }
    @DeleteMapping("/deleteCompany")
    public ResponseEntity<String> deleteCompanyById(long companyId){
        return new ResponseEntity<>(companyService.deleteById(companyId),HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getCompanyIdByCompanyName/{companyName}")
    public ResponseEntity<Company> getCompanyIdByCompanyName(@PathVariable String companyName) {
        return new ResponseEntity<>(companyService.getCompanyIdByCompanyName(companyName), HttpStatus.OK);
    }
}
