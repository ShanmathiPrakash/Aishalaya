package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.ExceptionHandling.CompanyNotFoundException;
import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.model.Team;
import com.example.RealEstateCRM.model.VisitDetails;
import com.example.RealEstateCRM.repository.TeamRepository;
import com.example.RealEstateCRM.repository.VisitDetailRepository;
import com.example.RealEstateCRM.service.VisitDetailService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VisitDetailServiceClass implements VisitDetailService {

    @Autowired
    VisitDetailRepository visitDetailRepository;
    @Autowired
    TeamRepository teamRepository;

    @Override
    public VisitDetails saveVisitDetail(VisitDetails visitDetails, MultipartFile photo) {
        // Fetch the teamId for each projectName
        List<String> projectNames = visitDetails.getProjectNames();
        Map<String, Long> projectNameToTeamIdMap = new HashMap<>();

        for (String projectName : projectNames) {
            // Assuming you have a method in your team repository to find team by project name
            Team team = teamRepository.findByProjectNames(projectName);
            if (team != null) {
                projectNameToTeamIdMap.put(projectName, team.getTeamId());
            } else {
                projectNameToTeamIdMap.put(projectName, null); // Indicate no teamId for this projectName
            }
        }

        // Set project names in the VisitDetails object
        visitDetails.setProjectNames(projectNames);

        // Save photo if present
        if (photo != null) {
            String fileName = savePhotoFile(photo);
            String photoUrl = "photoImages/" + fileName; // Assuming uploads directory for saved photos
            visitDetails.setPhoto(photoUrl);
        }

        // Check if all projectNames have corresponding teamId
        boolean allProjectNamesHaveTeamId = projectNameToTeamIdMap.values().stream().allMatch(Objects::nonNull);

        if (allProjectNamesHaveTeamId) {
            // If all projectNames have corresponding teamId, set the teamId in visitDetails
            // Assuming a single teamId for simplicity
            Long teamId = projectNameToTeamIdMap.values().iterator().next();
            visitDetails.setTeamId(teamId);
        } else {
            // If any projectName does not have corresponding teamId, throw an exception
            List<String> missingProjectNames = projectNameToTeamIdMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == null)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            throw new IllegalArgumentException("The following project names do not have a corresponding teamId: " + missingProjectNames);
        }

        // Save the original visit details
        return visitDetailRepository.save(visitDetails);
    }

    private String savePhotoFile(MultipartFile photo) {
        try {
            // Generate unique filename
            String fileName = photo.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "alldocuments/PhotoImages/"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName);
            Files.copy(photo.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    private void deleteFile(String fileUrl) {
        File file = new File(fileUrl);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public VisitDetails editVisitDetail(Long visitDetailId, VisitDetails visitDetail, MultipartFile photo) {
        Optional<VisitDetails> updateVisitDetailOptional = Optional.ofNullable(visitDetailRepository.findByVisitDetailId(visitDetailId));
        if (updateVisitDetailOptional.isPresent()) {
            VisitDetails updateVisitDetail = updateVisitDetailOptional.get();

            // Update other fields as before
            updateVisitDetail.setEmployeeCode(visitDetail.getEmployeeCode());
            updateVisitDetail.setDate(visitDetail.getDate());
            updateVisitDetail.setCustomerName(visitDetail.getCustomerName());
            updateVisitDetail.setPhoneNumber(visitDetail.getPhoneNumber());
            updateVisitDetail.setEmployeeName(visitDetail.getEmployeeName());
            updateVisitDetail.setStatus(visitDetail.getStatus());
            updateVisitDetail.setFundingSource(visitDetail.getFundingSource());
            updateVisitDetail.setBuyingDuration(visitDetail.getBuyingDuration());
            updateVisitDetail.setVehicleType(visitDetail.getVehicleType());
            updateVisitDetail.setCab(visitDetail.getCab());
            updateVisitDetail.setDriver(visitDetail.getDriver());
            updateVisitDetail.setStartingKms(visitDetail.getStartingKms());
            updateVisitDetail.setEndKms(visitDetail.getEndKms());
            updateVisitDetail.setStartingTime(visitDetail.getStartingTime());
            updateVisitDetail.setEmployeeNotes(visitDetail.getEmployeeNotes());
            updateVisitDetail.setCompanyId(visitDetail.getCompanyId());

            // Fetch the teamId for each projectName
            List<String> currentProjectNames = updateVisitDetail.getProjectNames();
            List<String> newProjectNames = visitDetail.getProjectNames();

            // Combine current and new project names, removing duplicates
            Set<String> uniqueProjectNames = new HashSet<>(currentProjectNames);
            uniqueProjectNames.addAll(newProjectNames);

            // Prepare a map to hold projectName to teamId mappings
            Map<String, Long> projectNameToTeamIdMap = new HashMap<>();

            for (String projectName : uniqueProjectNames) {
                // Assuming you have a method in your team repository to find team by project name
                Team team = teamRepository.findByProjectNames(projectName);
                if (team != null) {
                    projectNameToTeamIdMap.put(projectName, team.getTeamId());
                } else {
                    projectNameToTeamIdMap.put(projectName, null); // Indicate no teamId for this projectName
                }
            }

            // Set project names in the VisitDetails objectsss
            updateVisitDetail.setProjectNames(new ArrayList<>(uniqueProjectNames));

            // Check if all projectNames have corresponding teamId
            boolean allProjectNamesHaveTeamId = projectNameToTeamIdMap.values().stream().allMatch(Objects::nonNull);

            if (allProjectNamesHaveTeamId) {
                // If all projectNames have corresponding teamId, set the teamId in visitDetails
                // Assuming a single teamId for simplicity
                Long teamId = projectNameToTeamIdMap.values().iterator().next();
                updateVisitDetail.setTeamId(teamId);
            } else {
                // If any projectName does not have corresponding teamId, throw an exception
                List<String> missingProjectNames = projectNameToTeamIdMap.entrySet().stream()
                        .filter(entry -> entry.getValue() == null)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

                throw new IllegalArgumentException("The following project names do not have a corresponding teamId: " + missingProjectNames);
            }

            // Save photo if present
            if (photo != null) {
                deleteFile(updateVisitDetail.getPhoto());
                String fileName = savePhotoFile(photo);
                String photoUrl = "photoImages/" + fileName; // Assuming uploads directory for saved photos
                updateVisitDetail.setPhoto(photoUrl);
            }

            return visitDetailRepository.save(updateVisitDetail);
        } else {
            throw new ResourceNotFoundException("Visit Detail with ID: " + visitDetailId + " not found");
        }
    }


    @Override
    public VisitDetails getVisitDetailById(Long VisitDetailId){
        Optional<VisitDetails> updateVisitDetailOptional = Optional.ofNullable(visitDetailRepository.findByVisitDetailId(VisitDetailId));
        return updateVisitDetailOptional.get();
    }
    @Override
    public Optional<List<VisitDetails>> getVisitDetails() {
        Optional<List<VisitDetails>> visitDetailsList = Optional.ofNullable(visitDetailRepository.findAll());
        return visitDetailsList;
    }
    @Override
    public String deleteVisitDetailById(long visitId){
        Optional<VisitDetails> visitOptional = visitDetailRepository.findById(visitId);

        if (visitOptional.isPresent()) {
            // Company found, proceed with deletion logic
            visitDetailRepository.deleteById(visitId);
            return "VisitDetail deleted successfully";
        } else {
            // Company not found, throw an exception
            throw new CompanyNotFoundException("VisitDetail with ID " + visitId + " not found");
        }
    }
    @Override
    public List<VisitDetails> getByCustomerNames(List<String> customerName) {
        return visitDetailRepository.findByCustomerNameIn(customerName);
    }
    @Override
    public List<VisitDetails> getByPhoneNumbers(List<String> phoneNumber) {
        return visitDetailRepository.findByPhoneNumberIn(phoneNumber);
    }
    @Override
    public List<VisitDetails> getByEmployeeNames(List<String> employeeName) {
        return  visitDetailRepository.findByEmployeeNameIn(employeeName);
    }
    @Override
    public List<VisitDetails> getByFundingSources(List<String> fundingSource) {
        return visitDetailRepository.findByFundingSourceIn(fundingSource);
    }
    @Override
    public List<VisitDetails> getByBuyingDurations(List<String> buyingDuration) {
        return visitDetailRepository.findByBuyingDurationIn(buyingDuration);
    }
    @Override
    public List<VisitDetails> getByProjectNames(List<String> projectNames) {
        return visitDetailRepository.findByProjectNamesIn(projectNames);
    }
    @Override
    public List<VisitDetails> getByDateRange(Date startDate, Date endDate) {
        return visitDetailRepository.findByDateBetween(startDate, endDate);
    }
    @Override
    public List<VisitDetails> getByStatus(List<String> status) {
        return  visitDetailRepository.findByStatusIn(status);
    }

    @Override
    public List<VisitDetails> getVisitDetailsByCompanyId(Long companyId) {
        List<VisitDetails> visitDetails = visitDetailRepository.findByCompanyId(companyId);
        if (visitDetails.isEmpty()) {
            throw new EntityNotFoundException("VisitDetails not found for companyId: " + companyId);
        }
        return visitDetails;
    }

    @Override
    public List<VisitDetails> getVisitDetailsByCompanyIdAndTeamId(Long companyId, List<Long> teamId) {
        return visitDetailRepository.findByCompanyIdAndTeamIdIn(companyId, teamId);
    }

    @Override
    public VisitDetails getByVisitDetailIdAndProjectNameForBlockRelease(Long visitDetailId, String projectName) {
        Optional<VisitDetails> optionalVisitDetails = visitDetailRepository.findById(visitDetailId);

        if (optionalVisitDetails.isPresent())
        {
            System.out.println("visitdetail:"+optionalVisitDetails);
            VisitDetails visitDetails = optionalVisitDetails.get();
            // Check if the projectNames list contains the specified projectName
            if (visitDetails.getProjectNames().contains(projectName))
            {
                visitDetails.setIsBlock(true);
                visitDetails.setIsBook(true); // Set isBlock to true
                visitDetailRepository.save(visitDetails); // Save the updated entity
                return visitDetails; // Return the updated VisitDetails
            }
            else
            {
                throw new CompanyNotFoundException("visit detail is not obtaines in:"+visitDetailId+ "and" +projectName);
            }
        }
        return null;
    }
    @Override
    public VisitDetails getByVisitDetailIdAndProjectNameForBlock(Long visitDetailId, String projectName) {
        Optional<VisitDetails> optionalVisitDetails = visitDetailRepository.findById(visitDetailId);

        if (optionalVisitDetails.isPresent())
        {
            System.out.println("visitdetail:"+optionalVisitDetails);
            VisitDetails visitDetails = optionalVisitDetails.get();
            // Check if the projectNames list contains the specified projectName
            if (visitDetails.getProjectNames().contains(projectName))
            {
                visitDetails.setIsBlock(false); // Set isBlock to true
                visitDetails.setIsBook(true);
                visitDetailRepository.save(visitDetails); // Save the updated entity
                return visitDetails; // Return the updated VisitDetails
            }
            else
            {
                throw new CompanyNotFoundException("visit detail is not obtaines in:"+visitDetailId+ "and" +projectName);
            }
        }
        return null;
    }

    @Override
    public VisitDetails getByVisitDetailIdAndProjectNameForBook(Long visitDetailId, String projectName) {
        Optional<VisitDetails> optionalVisitDetails = visitDetailRepository.findById(visitDetailId);

        if (optionalVisitDetails.isPresent())
        {
            System.out.println("visitdetail:"+optionalVisitDetails);
            VisitDetails visitDetails = optionalVisitDetails.get();
            // Check if the projectNames list contains the specified projectName
            if (visitDetails.getProjectNames().contains(projectName))
            {
                visitDetails.setIsBlock(false); // Set isBlock to true
                visitDetails.setIsBook(false);
                visitDetailRepository.save(visitDetails); // Save the updated entity
                return visitDetails; // Return the updated VisitDetails
            }
            else
            {
                throw new CompanyNotFoundException("visit detail is not obtaines in:"+visitDetailId+ "and" +projectName);
            }
        }
        return null;
    }
}

