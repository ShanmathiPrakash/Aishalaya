package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.model.VisitDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BlocksRepository extends JpaRepository<Blocks,Long> {
    List<Blocks> findByCustomerNameIn(List<String> customerName);
    List<Blocks> findByMobileNumberIn(List<String> mobileNumber);
    List<Blocks> findByBlockEmpNameIn(List<String> blockEmpName);
   List<Blocks> findByPaidDateBetween(Date startDate, Date endDate);
    Blocks findByVisitIdAndProjectName(Long visitId, String projectName);
    List<Blocks> findByProjectId(Long projectId);
    Blocks findByVisitIdAndProjectNameAndPlotNumber(Long visitId, String projectName, Long plotNumber);


    List<Blocks> findByCompanyIdAndTeamIdIn(Long companyId, List<Long> teamId);

    List<Blocks> findByCompanyId(Long companyId);
}
