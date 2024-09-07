package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.model.Customer;
import com.example.RealEstateCRM.model.Project;
import com.example.RealEstateCRM.model.ProjectLayout;
import com.example.RealEstateCRM.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @PostMapping("/addProject")
    public ResponseEntity<Project> addProjects(@RequestPart Project project,@RequestPart("agreementDocuments") MultipartFile agreementDocuments,@RequestPart("draftDocuments")MultipartFile draftDocuments,
                                               @RequestPart("documentDocuments")MultipartFile documentDocuments,@RequestPart("legalDocuments")MultipartFile legalDocuments,
                                               @RequestPart("legalBookDocuments")MultipartFile legalBookDocuments,
                                               @RequestPart("dtcpDocuments")MultipartFile dtcpDocuments,@RequestPart("corporationDocuments")MultipartFile corporationDocuments,@RequestPart("layout")MultipartFile layout) {
        return new ResponseEntity<Project>(projectService.addProject(project,agreementDocuments,draftDocuments,documentDocuments,legalDocuments,legalBookDocuments,dtcpDocuments,corporationDocuments,layout), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/getAllProjectDetails")
    public ResponseEntity<List<Project>> getAllProjectDetails() {
        List<Project> projects = projectService.projectDetails();
        return ResponseEntity.ok(projects);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/getProjectById/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long projectId) {
        Project project = projectService.getProjectById(projectId);
        return ResponseEntity.ok(project);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/getProjectByProjectName/{projectName}")
    public ResponseEntity<Project> getProjectByProjectName(@PathVariable String projectName) {
        Project project = projectService.getProjectByProjectName(projectName);
        return ResponseEntity.ok(project);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/getProjectByDistrict/{district}")
    public ResponseEntity<Project> getProjectByDistrict(@PathVariable String district) {
        Project project = projectService.getProjectByDistrict(district);
        return ResponseEntity.ok(project);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/getProjectByTaluk/{taluk}")
    public ResponseEntity<Project> getProjectByTaluk(@PathVariable String taluk) {
        Project project = projectService.getProjectByTaluk(taluk);
        return ResponseEntity.ok(project);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/getProjectByVillage/{village}")
    public ResponseEntity<Project> getProjectByVillage(@PathVariable String village) {
        Project project = projectService.getProjectByVillage(village);
        return ResponseEntity.ok(project);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/getProjectsByLaunchDate")
    public List<Project> getProjectsByLaunchDate(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate launchDate) {
        return projectService.getProjectsByLaunchDate(launchDate);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @PutMapping("/updateProject/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable Long projectId, @RequestPart Project project,@RequestPart("agreementDocuments") MultipartFile agreementDocuments,@RequestPart("draftDocuments")MultipartFile draftDocuments,
                                                 @RequestPart("documentDocuments")MultipartFile documentDocuments,@RequestPart("legalDocuments")MultipartFile legalDocuments,
                                                 @RequestPart("legalBookDocuments")MultipartFile legalBookDocuments,
                                                 @RequestPart("dtcpDocuments")MultipartFile dtcpDocuments,@RequestPart("corporationDocuments")MultipartFile corporationDocuments,@RequestPart("layout")MultipartFile layout) {

        return new ResponseEntity<Project>(projectService.updateProject(projectId,project,agreementDocuments,draftDocuments,documentDocuments,legalDocuments,legalBookDocuments,dtcpDocuments,corporationDocuments,layout), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @DeleteMapping("/deleteProjectById/{projectId}")
    public ResponseEntity<String> deleteProjectById(@PathVariable Long projectId) {
        return new ResponseEntity<String>(projectService.deleteProjectById(projectId), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @PostMapping("/addProjectLayout")
    public ResponseEntity<ProjectLayout> addProjectLayout(@RequestBody ProjectLayout projectLayout) {
        return new ResponseEntity<ProjectLayout>(projectService.addProjectLayout(projectLayout), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/projectLayoutDetails")
    public ResponseEntity<List<ProjectLayout>> getAllProjectLayoutDetails() {
        List<ProjectLayout> projectLayouts = projectService.projectLayoutDetails();
        return ResponseEntity.ok(projectLayouts);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/getProjectLayoutById/{ProjectLayoutId}")
    public ResponseEntity<ProjectLayout> getProjectLayoutById(@PathVariable Long ProjectLayoutId) {
        ProjectLayout projectLayout = projectService.getProjectLayoutById(ProjectLayoutId);
        return ResponseEntity.ok(projectLayout);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @PutMapping("/updateProjectLayout/{ProjectLayoutId}")
    public ResponseEntity<ProjectLayout> updateProjectLayout(@PathVariable Long ProjectLayoutId, @RequestBody ProjectLayout projectLayout) {
        return new ResponseEntity<ProjectLayout>(projectService.updateProjectLayout(ProjectLayoutId,projectLayout), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/getProjectLayout/{plotNumber}/{totalSqft}/{rate}")
    public ResponseEntity<ProjectLayout> getProjectLayout(@PathVariable Long plotNumber, @PathVariable Double totalSqft, @PathVariable Double rate) {
        ProjectLayout projectLayout = projectService.getProjectLayout(plotNumber,totalSqft,rate);
        return ResponseEntity.ok(projectLayout);
    }

    //    @PreAuthorize("@securityServiceImpl.isAccessible('project')")
    @GetMapping("/getProjectLayoutByPlotNo/{plotNumber}")
    public ResponseEntity<ProjectLayout> getProjectLayoutByPlotNo(@PathVariable Long plotNumber) {
        ProjectLayout projectLayout = projectService.getProjectLayoutByPlotNo(plotNumber);
        return ResponseEntity.ok(projectLayout);

    }
    @GetMapping("/getProjectLayoutByProId/{projectId}")
    public ResponseEntity<List<ProjectLayout>> getProjectLayoutByProId(@PathVariable Long projectId) {
        List<ProjectLayout> projectLayout = projectService.getProjectLayoutByProId(projectId);
        return ResponseEntity.ok(projectLayout);
    }

@GetMapping("getProjectLayoutDetailsByProjectNameAndPlotNumber/{projectName}/{plotNumber}")
public ResponseEntity<ProjectLayout> getProjectLayoutDetailsByProjectNameAndPlotNumber(@PathVariable String projectName, @PathVariable Long plotNumber) {
    ProjectLayout visitDetailOptional = projectService.getProjectLayoutDetailsByProjectNameAndPlotNumber(projectName,plotNumber);
    return ResponseEntity.ok(visitDetailOptional);
}

@GetMapping("/getProjectLayoutByProIdAndStatus/{projectId}")
public ResponseEntity<List<ProjectLayout>> getProjectLayoutByProIdAndStatus(@PathVariable Long projectId) {
    List<ProjectLayout> projectLayout = projectService.getProjectLayoutByProIdAndStatus(projectId);
        return ResponseEntity.ok(projectLayout);
}

    @GetMapping("/getProjectLayoutByCompanyIdAndPlotId/{projectName}/{plotId}")
    public ResponseEntity<ProjectLayout> getProjectLayout(@PathVariable String projectName, @PathVariable Long plotId) {
        ProjectLayout projectLayout = projectService.getProjectLayoutByProjectIdAndPlotId(projectName, plotId);
        return ResponseEntity.ok(projectLayout);
    }

    @GetMapping("/getProjectLayoutByProjectId/{ProjectLayoutId}")
    public ResponseEntity<ProjectLayout> getProjectLayoutByProjectId(@PathVariable Long ProjectLayoutId) {
        ProjectLayout projectLayout = projectService.getProjectLayoutByProjectLayoutId(ProjectLayoutId);
        return ResponseEntity.ok(projectLayout);
    }
    @GetMapping("/getProjectLayoutByProjectName/{projectName}")
    public ResponseEntity<List<ProjectLayout>> getProjectLayoutByProjectName(@PathVariable String projectName) {
    List<ProjectLayout> projectLayouts = projectService.getProjectLayoutByProjectName(projectName);
    return ResponseEntity.ok(projectLayouts);
    }

    @GetMapping("/getProjectsByCompanyId/{companyId}")
    public ResponseEntity<List<Project>> getProjectByCompanyId(@PathVariable Long companyId) {
        List<Project> projects = projectService.getProjectByCompanyId(companyId);
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/companyAndTeamId/{companyId}/{teamId}")
    public List<Project> getProjectByCompanyAndTeam(@PathVariable Long companyId, @PathVariable List<Long> teamId)
    {
        return projectService.getProjectByCompanyIdAndTeamId(companyId, teamId);
    }
}