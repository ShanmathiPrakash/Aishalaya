package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
import com.example.RealEstateCRM.model.Project;
import com.example.RealEstateCRM.model.ProjectLayout;
import com.example.RealEstateCRM.repository.ProjectLayoutRepository;
import com.example.RealEstateCRM.repository.ProjectRepository;
import com.example.RealEstateCRM.service.ProjectService;
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
import java.time.LocalDate;
import java.util.*;

@Service
public class ProjectServiceClass implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectLayoutRepository projectLayoutRepository;

    @Override
    public Project addProject(Project project, MultipartFile agreementDocuments, MultipartFile draftDocuments, MultipartFile documentDocuments, MultipartFile legalDocuments,
                              MultipartFile legalBookDocuments, MultipartFile dtcpDocuments, MultipartFile corporationDocuments, MultipartFile layout) {

        // Check if a project with the same projectName already exists
        String projectName = project.getProjectName();
        Optional<Project> existingProject = Optional.ofNullable(projectRepository.findByProjectName(projectName));

        if (existingProject.isPresent()) {
            throw new IllegalArgumentException("A project with the name " + projectName + " already exists.");
        }

        // Check if all required documents are provided
        if (agreementDocuments != null && draftDocuments != null && legalDocuments != null && documentDocuments != null
                && legalBookDocuments != null && dtcpDocuments != null && corporationDocuments != null && layout != null) {

            // Save each document and set the respective URLs
            String fileName = saveLogoFile(agreementDocuments);
            String fileName1 = saveLogoFile1(draftDocuments);
            String fileName2 = saveLogoFile2(legalDocuments);
            String fileName3 = saveLogoFile3(documentDocuments);
            String fileName4 = saveLogoFile4(legalBookDocuments);
            String fileName5 = saveLogoFile5(dtcpDocuments);
            String fileName6 = saveLogoFile6(corporationDocuments);
            String fileName7 = saveLogoFile7(layout);

            String logoUrl = "/pages/setup/projectImages/agreementDocument/" + fileName;
            String logoUrl1 = "/pages/setup/projectImages/draftDocument/" + fileName1;
            String logoUrl2 = "/pages/setup/projectImages/documentDocument/" + fileName2;
            String logoUrl3 = "/pages/setup/projectImages/legalDocument/" + fileName3;
            String logoUrl4 = "/pages/setup/projectImages/legalBookDocument/" + fileName4;
            String logoUrl5 = "/pages/setup/projectImages/dtcpDocument/" + fileName5;
            String logoUrl6 = "/pages/setup/projectImages/corporationDocument/" + fileName6;
            String logoUrl7 = "/pages/setup/projectImages/layout/" + fileName7;

            project.setAgreementDocuments(logoUrl);
            project.setDraftDocuments(logoUrl1);
            project.setLegalDocuments(logoUrl2);
            project.setDocumentDocuments(logoUrl3);
            project.setLegalBookDocuments(logoUrl4);
            project.setDtcpDocuments(logoUrl5);
            project.setCorporationDocuments(logoUrl6);
            project.setLayout(logoUrl7);
        }

        // Save the project to the database
        return projectRepository.save(project);
    }


    private String saveLogoFile7(MultipartFile layout) {
        try {
            // Generate unique filename
            String fileName7 = UUID.randomUUID().toString() + "_" + layout.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/projectImages/logoFile"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName7);
            Files.copy(layout.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName7; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    private String saveLogoFile6(MultipartFile corporationDocuments) {

        try {
            // Generate unique filename
            String fileName6 = UUID.randomUUID().toString() + "_" + corporationDocuments.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/projectImages/corporationDocument"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName6);
            Files.copy(corporationDocuments.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName6; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    private String saveLogoFile5(MultipartFile dtcpDocuments) {
        try {
            // Generate unique filename
            String fileName5 = UUID.randomUUID().toString() + "_" + dtcpDocuments.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/projectImages/dtcpDocument"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName5);
            Files.copy(dtcpDocuments.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName5; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    private String saveLogoFile4(MultipartFile legalBookDocuments) {
        try {
            // Generate unique filename
            String fileName4 = UUID.randomUUID().toString() + "_" + legalBookDocuments.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/projectImages/legalBookDocument"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName4);
            Files.copy(legalBookDocuments.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName4; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    private String saveLogoFile3(MultipartFile documentDocuments) {
        try {
            // Generate unique filename
            String fileName3 = UUID.randomUUID().toString() + "_" + documentDocuments.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/projectImages/documentDocument" ; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName3);
            Files.copy(documentDocuments.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName3; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    private String saveLogoFile2(MultipartFile legalDocuments) {
        try {
            // Generate unique filename
            String fileName2 = UUID.randomUUID().toString() + "_" + legalDocuments.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/pages/setup/projectImages/legalDocument"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName2);
            Files.copy(legalDocuments.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName2; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    private String saveLogoFile1(MultipartFile draftDocuments) {
        try {
            // Generate unique filename
            String fileName1 = UUID.randomUUID().toString() + "_" + draftDocuments.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/projectImages/draftDocument"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName1);
            Files.copy(draftDocuments.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName1; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    private String saveLogoFile(MultipartFile agreementDocuments) {
        try {
            // Generate unique filename
            String fileName = UUID.randomUUID().toString() + "_" + agreementDocuments.getOriginalFilename();
            // Define directory to save files
            String uploadDirStr = "/var/www/html/rosemallow/pages/setup/projectImages/agreementDocument"; // Relative path to the directory
            Path uploadDir = Paths.get(uploadDirStr);
            // Resolve the absolute path
            Path absoluteUploadDir = Paths.get(System.getProperty("user.dir")).resolve(uploadDir);
            // Create directory if it doesn't exist
            if (!Files.exists(absoluteUploadDir)) {
                Files.createDirectories(absoluteUploadDir);
            }
            // Save file to directory
            Path filePath = absoluteUploadDir.resolve(fileName);
            Files.copy(agreementDocuments.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName; // Return the saved filename
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
            return null; // Or throw an exception here
        }
    }

    @Override
    public List<Project> projectDetails() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with projectId: " + projectId));
    }

    @Override
    public Project updateProject(Long projectId, Project project, MultipartFile agreementDocuments, MultipartFile draftDocuments, MultipartFile documentDocuments, MultipartFile legalDocuments, MultipartFile legalBookDocuments,
                                 MultipartFile dtcpDocuments, MultipartFile corporationDocuments, MultipartFile layout) {
        Optional<Project> ans = projectRepository.findById(projectId);
        Project project1 = ans.get();
        project1.setCompanyName(project.getCompanyName());
        project1.setProjectName(project.getProjectName());
        project1.setLaunchDate(project.getLaunchDate());
        project1.setLandType(project.getLandType());
        project1.setDistrict(project.getDistrict());
        project1.setTaluk(project.getTaluk());
        project1.setVillage(project.getVillage());
        project1.setExtent(project.getExtent());
        project1.setAddress(project.getAddress());
        project1.setGeoLocation(project.getGeoLocation());
        project1.setTotalSiteSqft(project.getTotalSiteSqft());
        project1.setTotalSiteCent(project.getTotalSiteCent());
        project1.setSaleableSqft(project.getSaleableSqft());
        project1.setSaleableCent(project.getSaleableCent());
        project1.setRoadSqft(project.getRoadSqft());
        project1.setRoadCent(project.getRoadCent());
        project1.setTotalPlots(project.getTotalPlots());
        project1.setRoadSqft(project.getRoadSqft());
        project1.setEastDetails(project.getEastDetails());
        project1.setWestDetails(project.getWestDetails());
        project1.setNorthDetails(project.getNorthDetails());
        project1.setSouthDetails(project.getSouthDetails());
        project1.setPrevOwnerName(project.getPrevOwnerName());
        project1.setPrevOwnerContact(project.getPrevOwnerContact());
        project1.setPrevOwnerAddress(project.getPrevOwnerAddress());
        project1.setAgreementDetails(project.getAgreementDetails());
        project1.setDraftDetails(project.getDraftDetails());
        project1.setLegalDetails(project.getLegalDetails());
        project1.setDocumentDetails(project.getDocumentDetails());
        project1.setLegalBookDetails(project.getLegalBookDetails());
        project1.setDtcpDetails(project.getDtcpDetails());
        project1.setCorporationDetails(project.getCorporationDetails());
        project1.setRegistrationDetails(project.getRegistrationDetails());
        if (agreementDocuments != null && draftDocuments != null && legalDocuments != null && documentDocuments != null
                && legalBookDocuments != null && dtcpDocuments != null && corporationDocuments != null && layout != null) {
            deleteFile(project1.getDraftDocuments());
            deleteFile(project1.getLegalDocuments());
            deleteFile(project1.getDocumentDocuments());
            deleteFile(project1.getLegalBookDocuments());
            deleteFile(project1.getDtcpDocuments());
            deleteFile(project1.getCorporationDocuments());
            deleteFile(project1.getLayout());
            String fileName = saveLogoFile(agreementDocuments);
            String fileName1 = saveLogoFile1(draftDocuments);
            String fileName2 = saveLogoFile2(legalDocuments);
            String fileName3 = saveLogoFile3(documentDocuments);
            String fileName4 = saveLogoFile4(legalBookDocuments);
            String fileName5 = saveLogoFile5(dtcpDocuments);
            String fileName6 = saveLogoFile6(corporationDocuments);
            String fileName7 = saveLogoFile7(layout);
            String logoUrl = "/pages/setup/projectImages/agreementDocument/" + fileName;
            String logoUrl1 = "/pages/setup/projectImages/draftDocument/" + fileName1;
            String logoUrl2 = "/pages/setup/projectImages/documentDocuments/" + fileName2;
            String logoUrl3 = "/pages/setup/projectImages/legalDocument/" + fileName3;
            String logoUrl4 = "/pages/setup/projectImages/legalBookDocument/" + fileName4;
            String logoUrl5 = "/pages/setup/projectImages/dtcpDocument/" + fileName5;
            String logoUrl6 = "/pages/setup/projectImages/corporationDocument/" + fileName6;
            String logoUrl7 = "/pages/setup/projectImages/projectImages/layout/" + fileName7;// Assuming uploads directory for saved logos
            project1.setAgreementDocuments(logoUrl);
            project1.setDraftDocuments(logoUrl1);
            project1.setLegalDocuments(logoUrl2);
            project1.setDocumentDocuments(logoUrl3);
            project1.setLegalBookDocuments(logoUrl4);
            project1.setDtcpDocuments(logoUrl5);
            project1.setCorporationDocuments(logoUrl6);
            project1.setLayout(logoUrl7);
        }

        return projectRepository.save(project1);
    }

    private void deleteFile(String fileUrl) {
        File file = new File(fileUrl);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public String deleteProjectById(Long projectId) {
        Optional<Project> myData = projectRepository.findById(projectId);
        if (myData.isPresent()) {
            projectRepository.deleteById(projectId);
            return "Project Deleted...Successfully...";
        }
        return "Project Deletion...Failed...";
    }

    @Override
    public Project getProjectByProjectName(String projectName) {
        return projectRepository.findByProjectName(projectName);
    }

    @Override
    public Project getProjectByDistrict(String district) {
        return projectRepository.findByDistrict(district);
    }

    @Override
    public Project getProjectByTaluk(String taluk) {
        return projectRepository.findByTaluk(taluk);
    }

    @Override
    public Project getProjectByVillage(String village) {
        return projectRepository.findByVillage(village);
    }

    @Override
    public List<Project> getProjectsByLaunchDate(LocalDate launchDate) {
        return projectRepository.findByLaunchDate(launchDate);
    }


    @Override
    public ProjectLayout addProjectLayout(ProjectLayout projectLayout) {

        // Check if a ProjectLayout with the same plotNumber already exists for the given projectId
        Long projectId = projectLayout.getProjectId();
        Long plotNumber = projectLayout.getPlotNumber(); // Ensure this matches your actual data type (Long or String)

        // Fetch layout by projectId and plotNumber
        Optional<ProjectLayout> existingLayout = Optional.ofNullable(projectLayoutRepository.findByProjectIdAndPlotNumber(projectId, plotNumber));

        if (existingLayout.isPresent()) {
            throw new IllegalArgumentException("A layout with the plot number " + plotNumber + " already exists for this project.");
        }

        // Save the ProjectLayout object to the database
        projectLayout = projectLayoutRepository.save(projectLayout);

        // Fetch the total number of plots for the given projectId
        Long totalPlots = projectLayoutRepository.countByProjectId(projectId);

        // Fetch the Project object from the database
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found for id: " + projectId));

        // Update the totalPlots field in the Project object
        project.setTotalPlots(totalPlots);

        // Save the updated Project object back to the database
        projectRepository.save(project);

        return projectLayout;
    }




    @Override
    public ProjectLayout getProjectLayoutById(Long plotNumber) {
        return projectLayoutRepository.findByPlotNumber(plotNumber)
                .orElseThrow(() -> new EntityNotFoundException("ProjectLayout not found with ProjectLayoutId: " + plotNumber));
    }

    @Override
    public ProjectLayout updateProjectLayout(Long ProjectLayoutId, ProjectLayout projectLayout) {
        Optional<ProjectLayout> ans = projectLayoutRepository.findById(ProjectLayoutId);
        ProjectLayout projectLayout1 = ans.get();

        projectLayout1.setShape(projectLayout.getShape());
        projectLayout1.setDescrip(projectLayout.getDescrip());
//        projectLayout1.setCcoords(projectLayout.getCcoords());
        projectLayout1.setTotalSqft(projectLayout.getTotalSqft());
        projectLayout1.setRate(projectLayout.getRate());
        projectLayout1.setMsp(projectLayout.getMsp());
        projectLayout1.setStatus(projectLayout.getStatus());
        return projectLayoutRepository.save(projectLayout1);

    }

    @Override
    public ProjectLayout getProjectLayout(Long plotNumber, Double totalSqft, Double rate) {
        Optional<ProjectLayout> optionalCustomer = projectLayoutRepository.findByPlotNumberAndTotalSqftAndRate(plotNumber, totalSqft, rate);

        // Check if customer exists and return it, or throw an exception if not found
        return optionalCustomer.orElseThrow(() -> new ResourceNotFoundException("ProjectLayout not found"));
    }

    @Override
    public ProjectLayout getProjectLayoutByPlotNo(Long plotNumber) {

        Optional<ProjectLayout> optionalCustomer = projectLayoutRepository.findByPlotNumber(plotNumber);

        // Check if customer exists and return it, or throw an exception if not found
        return optionalCustomer.orElseThrow(() -> new ResourceNotFoundException("ProjectLayout not found"));
    }

    @Override
    public List<ProjectLayout> projectLayoutDetails() {
        return projectLayoutRepository.findAll();
    }

    @Override
    public List<ProjectLayout> getProjectLayoutByProId(Long projectId) {
        return projectLayoutRepository.findByProjectId(projectId);
    }

    @Override
    public ProjectLayout getProjectLayoutDetailsByProjectNameAndPlotNumber(String projectName, Long plotNumber) {
        ProjectLayout blocks = projectLayoutRepository.findByProjectNameAndPlotNumber(projectName,plotNumber);
        if (blocks == null) {
            throw new EntityNotFoundException("Blocks not found with visitId: " + projectName + " and projectName: " + plotNumber);
        }
        return blocks;  }

    @Override
    public List<ProjectLayout> getProjectLayoutByProIdAndStatus(Long projectId) {
        return projectLayoutRepository.findByProjectIdAndStatus(projectId, "Available");
    }

    public ProjectLayout getProjectLayoutByProjectIdAndPlotId(String projectName, Long plotId) {
        Project project = projectRepository.findByProjectName(projectName);

        if (project == null) {
            throw new EntityNotFoundException("Project not found");
        }

        ProjectLayout projectLayout = projectLayoutRepository.findByProjectIdAndPlotNumber(project.getId(), plotId);

        if (projectLayout == null) {
            throw new EntityNotFoundException("ProjectLayout not found");
        }

        return projectLayout;
    }

    @Override
    public ProjectLayout getProjectLayoutByProjectLayoutId(Long projectLayoutId) {
        return projectLayoutRepository.findById(projectLayoutId)
                .orElseThrow(() -> new EntityNotFoundException("ProjectLayout not found with ProjectLayoutId: " + projectLayoutId));
    }
    @Override
    public List<ProjectLayout> getProjectLayoutByProjectName(String projectName)
    {
        return projectLayoutRepository.findByProjectName(projectName);
    }

    @Override
    public List<Project> getProjectByCompanyId(Long companyId) {
        List<Project> projects = projectRepository.findByCompanyId(companyId);
        if (projects.isEmpty()) {
            throw new EntityNotFoundException("Project not found for companyId: " + companyId);
        }
        return projects;
    }

    @Override
    public List<Project> getProjectByCompanyIdAndTeamId(Long companyId, List<Long> teamId) {
        return projectRepository.findByCompanyIdAndTeamIdIn(companyId, teamId);
    }
}
