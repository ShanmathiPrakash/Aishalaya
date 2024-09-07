package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.Project;
import com.example.RealEstateCRM.model.VisitDetails;
import com.example.RealEstateCRM.service.VisitDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/visit")
public class VisitController {
    @Autowired
    VisitDetailService visitDetailservice;

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @PostMapping("/visitDetail")
    public ResponseEntity<VisitDetails> createVisitDetail(@RequestPart("visitDetails") VisitDetails visitDetails,
                                                          @RequestPart("photo") MultipartFile photo) {
        return new ResponseEntity<>(visitDetailservice.saveVisitDetail(visitDetails, photo), HttpStatus.CREATED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @PutMapping("/editVisitDetail/{visitDetailId}")
    public ResponseEntity<VisitDetails> editVisitDetail(@PathVariable Long visitDetailId,@RequestPart("visitDetails") VisitDetails visitDetails,@RequestPart(value = "photo", required = false) MultipartFile photo) {
        return new ResponseEntity<>(visitDetailservice.editVisitDetail(visitDetailId,visitDetails,photo), HttpStatus.OK);
    }
    @GetMapping("/getVisitDetailsById/{visitDetailId}")
    public ResponseEntity<Optional<VisitDetails>> getVisitDetailById(@PathVariable Long visitDetailId) {
        Optional<VisitDetails> visitDetailOptional = Optional.ofNullable(visitDetailservice.getVisitDetailById(visitDetailId));
        return ResponseEntity.ok(visitDetailOptional);
    }
    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @GetMapping("/getVisitDetail")
    public ResponseEntity<Optional<List<VisitDetails>>> getVisitDetails(){
        return new ResponseEntity<>(visitDetailservice.getVisitDetails(),HttpStatus.OK);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")


    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @DeleteMapping("/deleteVisitDetail/{visitDetailId}")
    public ResponseEntity<String> deleteVisitDetailById(@PathVariable long visitDetailId){
        return new ResponseEntity<>(visitDetailservice.deleteVisitDetailById(visitDetailId),HttpStatus.NOT_FOUND);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @GetMapping("/getByCustomerNames")
    public ResponseEntity<List<VisitDetails>> getByCustomerNames(@RequestParam List<String> customerName) {
        List<VisitDetails> visitDetails = visitDetailservice.getByCustomerNames(customerName);
        return ResponseEntity.ok(visitDetails);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @GetMapping("/getByPhoneNumbers")
    public ResponseEntity<List<VisitDetails>> getByPhoneNumbers(@RequestParam List<String> phoneNumber) {
        List<VisitDetails> visitDetails = visitDetailservice.getByPhoneNumbers(phoneNumber);
        return ResponseEntity.ok(visitDetails);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @GetMapping("/getByEmployeeNames")
    public ResponseEntity<List<VisitDetails>> getByEmployeeNames(@RequestParam List<String> employeeName) {
        List<VisitDetails>  visitDetails = visitDetailservice.getByEmployeeNames(employeeName);
        return ResponseEntity.ok(visitDetails);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @GetMapping("/getByStatus")
    public ResponseEntity<List<VisitDetails>> getByStatus(@RequestParam List<String> status) {
        List<VisitDetails>  visitDetails = visitDetailservice.getByStatus(status);
        return ResponseEntity.ok(visitDetails);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @GetMapping("/getByFundingSources")
    public ResponseEntity<List<VisitDetails>> getByFundingSources(@RequestParam List<String> fundingSource) {
        List<VisitDetails> visitDetails = visitDetailservice.getByFundingSources(fundingSource);
        return ResponseEntity.ok(visitDetails);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @GetMapping("/getByBuyingDurations")
    public ResponseEntity<List<VisitDetails>> getByBuyingDurations(@RequestParam List<String> buyingDuration) {
        List<VisitDetails> visitDetails = visitDetailservice.getByBuyingDurations(buyingDuration);
        return ResponseEntity.ok(visitDetails);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @GetMapping("/getByProjectNames")
    public ResponseEntity<List<VisitDetails>> getByProjectNames(@RequestParam List<String> projectNames) {
        List<VisitDetails> visitDetails = visitDetailservice.getByProjectNames(projectNames);
        return ResponseEntity.ok(visitDetails);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('siteVisit')")
    @GetMapping("/getByDateRange")
    public ResponseEntity<List<VisitDetails>> getByDateRange(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<VisitDetails> visitDetails = visitDetailservice.getByDateRange(startDate, endDate);
        return ResponseEntity.ok(visitDetails);
    }


    @GetMapping("/getVisitDetailsByCompanyId/{companyId}")
    public ResponseEntity<List<VisitDetails>> getVisitDetailsByCompanyId(@PathVariable Long companyId) {
        List<VisitDetails> visitDetails = visitDetailservice.getVisitDetailsByCompanyId(companyId);
        return ResponseEntity.ok(visitDetails);
    }

    @GetMapping("/companyAndTeamId/{companyId}/{teamId}")
    public List<VisitDetails> getVisitDetailsByCompanyAndTeam(@PathVariable Long companyId, @PathVariable List<Long> teamId)
    {
        return visitDetailservice.getVisitDetailsByCompanyIdAndTeamId(companyId, teamId);
    }

    @PutMapping("/getByVisitDetailIdAndProjectNameForBlockRelease/{visitDetailId}/{projectName}")
    public ResponseEntity<Optional<VisitDetails>> getVisitDetailByVisitDetailIdAndProjectNameForBlockRelease(@PathVariable Long visitDetailId, @PathVariable String projectName)
    {
        Optional<VisitDetails> visitDetailOptional = Optional.ofNullable(visitDetailservice.getByVisitDetailIdAndProjectNameForBlockRelease(visitDetailId,projectName));

        return ResponseEntity.ok(visitDetailOptional);

    }

    @PutMapping("/getByVisitDetailIdAndProjectNameForBlock/{visitDetailId}/{projectName}")
    public ResponseEntity<Optional<VisitDetails>> getVisitDetailByVisitDetailIdAndProjectNameForBlock(@PathVariable Long visitDetailId, @PathVariable String projectName)
    {
        Optional<VisitDetails> visitDetailOptional = Optional.ofNullable(visitDetailservice.getByVisitDetailIdAndProjectNameForBlock(visitDetailId,projectName));

        return ResponseEntity.ok(visitDetailOptional);

    }
    @PutMapping("/getByVisitDetailIdAndProjectNameForBook/{visitDetailId}/{projectName}")
    public ResponseEntity<Optional<VisitDetails>> getVisitDetailByVisitDetailIdAndProjectNameForBook(@PathVariable Long visitDetailId, @PathVariable String projectName)
    {
        Optional<VisitDetails> visitDetailOptional = Optional.ofNullable(visitDetailservice.getByVisitDetailIdAndProjectNameForBook(visitDetailId,projectName));

        return ResponseEntity.ok(visitDetailOptional);

    }

}

