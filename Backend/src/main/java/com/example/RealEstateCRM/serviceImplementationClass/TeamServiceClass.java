package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.ExceptionHandling.ResourceNotFoundException;
import com.example.RealEstateCRM.model.Employee;
import com.example.RealEstateCRM.model.Project;
import com.example.RealEstateCRM.model.Team;
import com.example.RealEstateCRM.model.VisitDetails;
import com.example.RealEstateCRM.repository.EmployeeRepository;
import com.example.RealEstateCRM.repository.ProjectRepository;
import com.example.RealEstateCRM.repository.TeamRepository;
import com.example.RealEstateCRM.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeamServiceClass implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Team saveTeam(Team team) {

        List<String> projectNames = team.getProjectNames();

        // Initialize projectNames to an empty list if it is null
        if (projectNames == null) {
            projectNames = new ArrayList<>();
        }

        // Set project names in the VisitDetails object
        team.setProjectNames(projectNames);

        // Save the team first
        Team savedTeam = teamRepository.save(team);

        // Fetch employeeIds by employeeNames and managerIds by managerNames
        List<Long> managerIds = fetchEmployeeIdsByNames(team.getManagerNames());
        List<Long> employeeIds = fetchEmployeeIdsByNames(team.getEmployeeNames());

        // Set the IDs in the Team entity
        savedTeam.setManagerIds(managerIds);
        savedTeam.setEmployeeIds(employeeIds);

        // Assign team to corresponding employees (both employeeIds and managerIds) and update userId
        updateEmployeeTeam(managerIds, savedTeam);
        updateEmployeeTeam(employeeIds, savedTeam);

        // Update projects with teamId
        updateProjectsWithTeamId(savedTeam);

        return teamRepository.save(savedTeam);
    }


    private void updateProjectsWithTeamId(Team team) {
        // Check if projectNames is null and initialize to an empty list if needed
        List<String> projectNames = team.getProjectNames();
        if (projectNames == null) {
            projectNames = new ArrayList<>();
        }

        // Iterate over each project name in the team
        for (String projectName : projectNames) {
            // Fetch the project by project name
            Project project = projectRepository.findByProjectName(projectName);

            // Check if the project was found
            if (project != null) {
                // Update the team ID for the project
                project.setTeamId(team.getTeamId());
                // Save the updated project
                projectRepository.save(project);
            } else {
                // Log or handle cases where no project was found for the given project name
                System.out.println("Project with name '" + projectName + "' not found.");
            }
        }
    }


    private List<Long> fetchEmployeeIdsByNames(List<String> names) {
        return employeeRepository.findByEmployeeNameIn(names).stream()
                .map(Employee::getEmployeeId)
                .collect(Collectors.toList());
    }

    private void updateEmployeeTeam(List<Long> ids, Team team) {
        if (ids != null && !ids.isEmpty()) {
            List<Employee> employees = employeeRepository.findAllById(ids);
            for (Employee employee : employees) {
                // Update teamIds for managers
                if (employee.getEmployeeName() != null && !employee.getEmployeeName().isEmpty()) {
                    List<Long> existingTeamIds = employee.getTeamId() != null ? employee.getTeamId() : new ArrayList<>();
                    if (!existingTeamIds.contains(team.getTeamId())) {
                        existingTeamIds.add(team.getTeamId());
                        employee.setTeamId(existingTeamIds);
                    }
                }

                employee.setUserId(employee.getEmployeeId()); // Update userId with only the numeric ID
            }
            employeeRepository.saveAll(employees);
        }
    }




    @Override
    public Optional<List<Team>> teamDetails() {
        return Optional.ofNullable(teamRepository.findAll());
    }

    @Override
    public Team getTeamById(Long teamId) {
        Optional<Team> updateteamOptional = Optional.ofNullable(teamRepository.findByTeamId(teamId));
        return updateteamOptional.get();
    }

    @Override
    public Team editTeamDetail(Long teamId, Team team) {
        Optional<Team> updateTeamDetailOptional = Optional.ofNullable(teamRepository.findByTeamId(teamId));
        if (updateTeamDetailOptional.isPresent()) {
            Team updateTeam = updateTeamDetailOptional.get();

            // Update team fields
            updateTeam.setCompanyId(team.getCompanyId());
            updateTeam.setCompanyName(team.getCompanyName());
            updateTeam.setTeamName(team.getTeamName());

            // Fetch employeeIds by employeeNames and managerIds by managerNames
            List<Long> managerIds = fetchEmployeeIdsByNames(team.getManagerNames());
            List<Long> employeeIds = fetchEmployeeIdsByNames(team.getEmployeeNames());

            // Fetch current manager and employee names
            List<String> currentManagerNames = updateTeam.getManagerNames();
            List<String> newManagerNames = team.getManagerNames();
            List<String> currentEmployeeNames = updateTeam.getEmployeeNames();
            List<String> newEmployeeNames = team.getEmployeeNames();

            // Determine which names to remove and add
            List<String> managersToRemove = currentManagerNames.stream()
                    .filter(name -> !newManagerNames.contains(name))
                    .collect(Collectors.toList());
            List<String> employeesToRemove = currentEmployeeNames.stream()
                    .filter(name -> !newEmployeeNames.contains(name))
                    .collect(Collectors.toList());

            // Remove teamId from employees who are no longer managers
            removeTeamIdFromEmployees(managersToRemove, updateTeam);
            removeTeamIdFromEmployees(employeesToRemove, updateTeam);

            // Add teamId to new managers and employees
            updateEmployeeTeam(managerIds, updateTeam);
            updateEmployeeTeam(employeeIds, updateTeam);

            // Update team details
            updateTeam.setManagerIds(managerIds);
            updateTeam.setEmployeeIds(employeeIds);

            // Set new names in the team
            updateTeam.setManagerNames(new ArrayList<>(newManagerNames));
            updateTeam.setEmployeeNames(new ArrayList<>(newEmployeeNames));

            // Set or update project names
            List<String> currentProjectNames = updateTeam.getProjectNames();
            List<String> newProjectNames = team.getProjectNames();
            // Add new project names to the list
            currentProjectNames.addAll(newProjectNames);
            // Remove duplicates if necessary
            Set<String> uniqueProjectNames = new HashSet<>(currentProjectNames);
            updateTeam.setProjectNames(new ArrayList<>(uniqueProjectNames));

            // Update projects with the new teamId
            updateProjectsWithTeamId(updateTeam);

            return teamRepository.save(updateTeam);
        } else {
            throw new ResourceNotFoundException("Team with ID: " + teamId + " not found");
        }
    }

    @Override
    public List<Team> getTeamsByCompanyId(Long companyId) {
        List<Team> teams = teamRepository.findByCompanyId(companyId);
        if (teams.isEmpty()) {
            throw new EntityNotFoundException("Teams not found for companyId: " + companyId);
        }
        return teams;
    }


    @Autowired
    ProjectRepository projectRepository;
    private void removeTeamIdFromEmployees(List<String> names, Team team) {
        if (names != null && !names.isEmpty()) {
            List<Employee> employees = employeeRepository.findByEmployeeNameIn(names);
            for (Employee employee : employees) {
                List<Long> teamIds = employee.getTeamId();
                if (teamIds != null) {
                    teamIds.remove(team.getTeamId()); // Remove the team ID from the employee's list
                    employee.setTeamId(teamIds);
                }
            }
            employeeRepository.saveAll(employees);
        }
    }

//    private List<Long> fetchEmployeeIdsByNames(List<String> names) {
//        return employeeRepository.findByEmployeeNameIn(names).stream()
//                .map(Employee::getEmployeeId)
//                .collect(Collectors.toList());
//    }
//
//    private void updateEmployeeTeam(List<Long> ids, Team team) {
//        if (ids != null && !ids.isEmpty()) {
//            List<Employee> employees = employeeRepository.findAllById(ids);
//            for (Employee employee : employees) {
//                employee.setTeam(team);
//                employee.setUserId  (employee.getEmployeeId()); // Update userId with only the numeric ID
//            }
//            employeeRepository.saveAll(employees);
//        }
//    }

}
