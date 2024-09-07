package com.example.RealEstateCRM.controller;


import com.example.RealEstateCRM.model.Team;
import com.example.RealEstateCRM.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

        @PostMapping("/addTeam")
    public ResponseEntity<Team> addTeam(@RequestBody Team team) {
        Team savedTeam = teamService.saveTeam(team);
        return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
    }


    @GetMapping("/getAllTeamDetails")
    public ResponseEntity<Optional<List<Team>>> getTeamDetails() {
        return new ResponseEntity<>(teamService.teamDetails(), HttpStatus.OK);
    }

    @GetMapping("/getTeamDetailsById/{teamId}")
    public ResponseEntity<Optional<Team>> getTeamById(@PathVariable Long teamId) {
        Optional<Team> teamlOptional = Optional.ofNullable(teamService.getTeamById(teamId));
        return ResponseEntity.ok(teamlOptional);
    }

    @PutMapping("/editTeamDetail/{teamId}")
    public ResponseEntity<Team> editTeamDetail(@PathVariable Long teamId,@RequestBody Team team) {
        return new ResponseEntity<>(teamService.editTeamDetail(teamId,team), HttpStatus.OK);
    }

    @GetMapping("/getTeamsByCompanyId/{companyId}")
    public ResponseEntity<List<Team>> getTeamsByCompanyId(@PathVariable Long companyId) {
        List<Team> teams = teamService.getTeamsByCompanyId(companyId);
        return ResponseEntity.ok(teams);
    }

}
