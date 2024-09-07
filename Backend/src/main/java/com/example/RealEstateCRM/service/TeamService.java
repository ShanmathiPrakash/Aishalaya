package com.example.RealEstateCRM.service;


import com.example.RealEstateCRM.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService  {
    Team saveTeam(Team team);

    Optional<List<Team>> teamDetails();

    Team getTeamById(Long teamId);

    Team editTeamDetail(Long teamId, Team team);

    List<Team> getTeamsByCompanyId(Long companyId);
}
