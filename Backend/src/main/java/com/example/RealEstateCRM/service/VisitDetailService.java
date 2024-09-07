package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.VisitDetails;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VisitDetailService {
    public VisitDetails saveVisitDetail(VisitDetails visitDetail, MultipartFile photo);
    public VisitDetails editVisitDetail(Long visitDetailId, VisitDetails visitDetail, MultipartFile photo) ;
    public VisitDetails getVisitDetailById(Long VisitDetailId);
    public Optional<List<VisitDetails>> getVisitDetails();
    public String deleteVisitDetailById(long visitId);
    List<VisitDetails> getByCustomerNames(List<String> customerName);
    List<VisitDetails> getByPhoneNumbers(List<String> phoneNumber);
    List<VisitDetails> getByEmployeeNames(List<String> employeeName);
    List<VisitDetails> getByFundingSources(List<String> fundingSource);
    List<VisitDetails> getByBuyingDurations(List<String> buyingDuration);
    List<VisitDetails> getByProjectNames(List<String> projectNames);
    List<VisitDetails> getByDateRange(Date startDate, Date endDate);
    List<VisitDetails> getByStatus(List<String> status);

    List<VisitDetails> getVisitDetailsByCompanyId(Long companyId);

    List<VisitDetails> getVisitDetailsByCompanyIdAndTeamId(Long companyId, List<Long> teamId);

    VisitDetails getByVisitDetailIdAndProjectNameForBlockRelease(Long visitDetailId, String projectName);

    VisitDetails getByVisitDetailIdAndProjectNameForBlock(Long visitDetailId, String projectName);

    VisitDetails getByVisitDetailIdAndProjectNameForBook(Long visitDetailId, String projectName);
}
