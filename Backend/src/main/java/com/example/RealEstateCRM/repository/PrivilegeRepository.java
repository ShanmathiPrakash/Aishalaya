package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Privilege;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {

    

    Privilege findByCompanyCompanyIdAndTeamTeamId(Long companyId, Long teamId);


    Privilege findByCompanyCompanyIdAndUserId(Long companyId, Long userId);




    List<Privilege> findByCompanyCompanyIdAndUserIdAndTeamTeamIdIn(Long companyId, Long userId, List<Long> teamIds);
}
