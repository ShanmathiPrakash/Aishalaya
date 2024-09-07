package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.Project;
import com.example.RealEstateCRM.model.ProjectLayout;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project addProject(Project project, MultipartFile agreementDocuments,MultipartFile draftDocuments,MultipartFile documentDocuments,MultipartFile legalDocuments,MultipartFile legalBookDocuments,
                       MultipartFile dtcpDocuments,MultipartFile corporationDocuments,MultipartFile layout);
    List<Project> projectDetails();
    Project getProjectById(Long projectId);
    Project updateProject(Long projectId, Project project, MultipartFile agreementDocuments,MultipartFile draftDocuments,MultipartFile documentDocuments,MultipartFile legalDocuments,MultipartFile legalBookDocuments,
                          MultipartFile dtcpDocuments,MultipartFile corporationDocuments,MultipartFile layout);
    String deleteProjectById(Long projectId);
    Project getProjectByProjectName(String projectName);
    Project getProjectByDistrict(String district);
    Project getProjectByTaluk(String taluk);
    Project getProjectByVillage(String village);
    List<Project> getProjectsByLaunchDate(LocalDate launchDate);

    ProjectLayout addProjectLayout(ProjectLayout projectLayout);

    List<ProjectLayout> projectLayoutDetails();

    ProjectLayout getProjectLayoutById(Long ProjectLayoutId);

    ProjectLayout updateProjectLayout(Long ProjectLayoutId, ProjectLayout projectLayout);

    ProjectLayout getProjectLayout(Long plotNumber, Double totalSqft, Double rate);

    ProjectLayout getProjectLayoutByPlotNo(Long plotNumber);

    List<ProjectLayout> getProjectLayoutByProId(Long projectId);
    ProjectLayout getProjectLayoutDetailsByProjectNameAndPlotNumber(String projectName,Long plotNumber);


    public List<ProjectLayout> getProjectLayoutByProIdAndStatus(Long projectId);
    public ProjectLayout getProjectLayoutByProjectIdAndPlotId(String projectName, Long plotId);
    public ProjectLayout getProjectLayoutByProjectLayoutId(Long projectLayoutId);
    public List<ProjectLayout> getProjectLayoutByProjectName(String projectName);


    List<Project> getProjectByCompanyId(Long companyId);

    List<Project> getProjectByCompanyIdAndTeamId(Long companyId, List<Long> teamId);
}
