package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project findByProjectName(String projectName);
    Project findByDistrict(String district);
    Project findByTaluk(String taluk);
    Project findByVillage(String village);
    List<Project> findByLaunchDate(LocalDate launchDate);


    List<Project> findByCompanyId(Long companyId);

    List<Project> findByCompanyIdAndTeamIdIn(Long companyId, List<Long> teamId);
}
