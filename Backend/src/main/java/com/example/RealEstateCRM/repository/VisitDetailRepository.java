package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.VisitDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface VisitDetailRepository extends JpaRepository<VisitDetails,Long> {
    VisitDetails findByVisitDetailId(Long visitDetailId);
    List<VisitDetails> findByCustomerNameIn(List<String> customerName);
    List<VisitDetails> findByPhoneNumberIn(List<String> phoneNumber);
    List<VisitDetails> findByEmployeeNameIn(List<String> employeeName);
    List<VisitDetails> findByFundingSourceIn(List<String> fundingSource);
    List<VisitDetails> findByBuyingDurationIn(List<String> buyingDuration);
    List<VisitDetails> findByStatusIn(List<String> status);
    List<VisitDetails> findByDateBetween(Date startDate, Date endDate);
    List<VisitDetails> findByProjectNamesIn(List<String> projectNames);

    List<VisitDetails> findByCompanyId(Long companyId);

    List<VisitDetails> findByCompanyIdAndTeamIdIn(Long companyId, List<Long> teamId);
}

