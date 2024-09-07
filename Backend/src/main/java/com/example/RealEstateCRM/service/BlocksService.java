package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.model.Cab;
import com.example.RealEstateCRM.model.VisitDetails;

import java.util.Date;
import java.util.List;

public interface BlocksService {
    Blocks addBlocks(Blocks blocks);

    List<Blocks> blocksDetails();

    Blocks getBlocksById(Long blocksId);
    List<Blocks> getBlocksByProjectId(Long projectId);

    Blocks updateBlocks(Long blocksId, Blocks blocks);
    List<Blocks> getByCustomerNames(List<String> customerName);
    List<Blocks> getByPhoneNumbers(List<String> phoneNumber);
    List<Blocks> getByEmployeeNames(List<String> employeeName);

    List<Blocks> getByDateRange(Date startDate, Date endDate);
    Blocks getBlockDetailsByVisitIdAndProjectName(Long visitId, String projectName);
    String deleteBlockById(Long blockId);
    Blocks getBlockDetailsByVisitIdAndProjectNameAndPlotNumber(Long visitId, String projectName, Long plotNumber);

    List<Blocks> getBlocksByCompanyId(Long companyId);

    List<Blocks> getBlocksByCompanyIdAndTeamId(Long companyId, List<Long> teamId);
}
