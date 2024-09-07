package com.example.RealEstateCRM.repository;


import com.example.RealEstateCRM.model.ProjectLayout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectLayoutRepository extends JpaRepository<ProjectLayout,Long> {
    Optional<ProjectLayout> findByPlotNumberAndTotalSqftAndRate(Long plotNumber, Double totalSqft, Double rate);

    Optional<ProjectLayout> findByPlotNumber(Long plotNumber);
    List<ProjectLayout> findByProjectId(Long projectId);
    ProjectLayout findByProjectIdAndPlotNumber(Long projectId, Long plotNumber);
   // Optional<ProjectLayout> findByProjectIdAndPlotNumber(Long projectId, Long plotNumber);
    List<ProjectLayout> findByProjectIdAndStatus(Long projectId, String status);
    Long countByProjectId(Long projectId);
    List<ProjectLayout> findByProjectName(String projetName);

    ProjectLayout findByProjectNameAndPlotNumber(String projectName,Long plotNumber);
}
