package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.model.Cab;
import com.example.RealEstateCRM.model.ProjectLayout;
import com.example.RealEstateCRM.model.VisitDetails;
import com.example.RealEstateCRM.repository.BlocksRepository;
import com.example.RealEstateCRM.repository.ProjectLayoutRepository;
import com.example.RealEstateCRM.service.BlocksService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlocksServiceClass implements BlocksService {

    @Autowired
    BlocksRepository blocksRepository;

    @Autowired
    ProjectLayoutRepository projectLayoutRepository;

    @Override
    public Blocks addBlocks(Blocks blocks) {
        // Save the blocks entity
        Blocks savedBlock = blocksRepository.save(blocks);

        // Fetch the plotNumber from the saved block
        Long plotNumber = savedBlock.getPlotNumber();

        // Fetch the project layout entry by plotNumber
        Optional<ProjectLayout> projectLayoutOptional = projectLayoutRepository.findByPlotNumber(plotNumber);

        if (projectLayoutOptional.isPresent()) {
            // Get the project layout from the optional
            ProjectLayout projectLayout = projectLayoutOptional.get();

            // Set the status to blocked
            projectLayout.setStatus("blocked");

            // Save the updated project layout
            projectLayoutRepository.save(projectLayout);
        } else {
            // Handle the case where the project layout is not found (optional)
            throw new EntityNotFoundException("Project layout not found for plotNumber: " + plotNumber);
        }
        return savedBlock;
    }

    @Override
    public List<Blocks> blocksDetails() {
        return blocksRepository.findAll();
    }

    @Override
    public Blocks getBlocksById(Long blocksId) {
        return blocksRepository.findById(blocksId)
                .orElseThrow(() -> new EntityNotFoundException("Blocks not found with blocksId: " + blocksId));
    }

    @Override
    public List<Blocks> getBlocksByProjectId(Long projectId) {
        List<Blocks> blocks = blocksRepository.findByProjectId(projectId);
        if (blocks.isEmpty()) {
            throw new EntityNotFoundException("Blocks not found with projectId: " + projectId);
        }
        return blocks;
    }

    @Override
    public Blocks updateBlocks(Long blocksId, Blocks blocks) {
        Optional<Blocks> ans = blocksRepository.findById(blocksId);
        Blocks blocks1 = ans.get();
        blocks1.setCustomerName(blocks.getCustomerName());
        blocks1.setMobileNumber(blocks.getMobileNumber());
        blocks1.setEmployeeCode(blocks.getEmployeeCode());
        blocks1.setProjectName(blocks.getProjectName());
        blocks1.setEmail(blocks.getEmail());
        blocks1.setHouseName(blocks.getHouseName());
        blocks1.setStreetName(blocks.getStreetName());
        blocks1.setArea(blocks.getArea());
        blocks1.setCity(blocks.getCity());
        blocks1.setDistrict(blocks.getDistrict());
        blocks1.setState(blocks.getState());
        blocks1.setPostalCode(blocks.getPostalCode());
        blocks1.setPlotNumber(blocks.getPlotNumber());
        blocks1.setDescription(blocks.getDescription());
        blocks1.setTotalSqft(blocks.getTotalSqft());
        blocks1.setRatePerSqft(blocks.getRatePerSqft());
        blocks1.setTotalValues(blocks.getTotalValues());
        return blocksRepository.save(blocks1);
    }

    @Override
    public List<Blocks> getByCustomerNames(List<String> customerName) {
        return blocksRepository.findByCustomerNameIn(customerName);
    }

    @Override
    public List<Blocks> getByPhoneNumbers(List<String> phoneNumber) {
        return blocksRepository.findByMobileNumberIn(phoneNumber);
    }

    @Override
    public List<Blocks> getByEmployeeNames(List<String> employeeName) {
        return blocksRepository.findByBlockEmpNameIn(employeeName);
    }

    @Override
    public List<Blocks> getByDateRange(Date startDate, Date endDate) {
        return blocksRepository.findByPaidDateBetween(startDate, endDate);
    }

    @Override
    public Blocks getBlockDetailsByVisitIdAndProjectName(Long visitId, String projectName) {
        Blocks blocks = blocksRepository.findByVisitIdAndProjectName(visitId, projectName);
        if (blocks == null) {
            throw new EntityNotFoundException("Blocks not found with visitId: " + visitId + " and projectName: " + projectName);
        }
        return blocks;
    }


    @Override
    public String deleteBlockById(Long blockId) {
        Optional<Blocks> myData = blocksRepository.findById(blockId);
        if (myData.isPresent()) {
            blocksRepository.deleteById(blockId);
            return "Employee Deleted...Successfully...";
        }
        return "Employee Deletion...Failed...";
    }

    @Override
    public Blocks getBlockDetailsByVisitIdAndProjectNameAndPlotNumber(Long visitId, String projectName, Long plotNumber) {
        Blocks blocks = blocksRepository.findByVisitIdAndProjectNameAndPlotNumber(visitId, projectName, plotNumber);
        if (blocks == null) {
            throw new EntityNotFoundException("Blocks not found with visitId: " + visitId + " and projectName: " + projectName + "and plortNumber:" + plotNumber);
        }
        return blocks;
    }

    @Override
    public List<Blocks> getBlocksByCompanyId(Long companyId) {
        List<Blocks> blocks = blocksRepository.findByCompanyId(companyId);
        if (blocks.isEmpty()) {
            throw new EntityNotFoundException("Blocks not found for companyId: " + companyId);
        }
        return blocks;
    }

    @Override
    public List<Blocks> getBlocksByCompanyIdAndTeamId(Long companyId, List<Long> teamId) {
        return blocksRepository.findByCompanyIdAndTeamIdIn(companyId, teamId);
    }
}

