package com.example.RealEstateCRM.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Team")
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;
    private Long companyId;
    private String companyName;
    private String teamName;

    @ElementCollection
    private List<String> projectNames;

    @ElementCollection
    private List<Long> managerIds;

    @ElementCollection
    private List<Long> employeeIds;

    @ElementCollection
    private List<String> managerNames;

    @ElementCollection
    private List<String> employeeNames;


}
