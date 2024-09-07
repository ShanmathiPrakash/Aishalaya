package com.example.RealEstateCRM.repository;


import com.example.RealEstateCRM.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {


    Team findByTeamId(Long teamId);

    // Method to find all teams containing the project name
//    List<Team> findByProjectNames(String projectName);

    Team findByProjectNames(String projectName); // Adjust as needed

    List<Team> findByCompanyId(Long companyId);
}








