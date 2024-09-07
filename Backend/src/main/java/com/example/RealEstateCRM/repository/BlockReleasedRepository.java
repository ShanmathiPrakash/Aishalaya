package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.BlockReleased;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface
BlockReleasedRepository extends JpaRepository<BlockReleased,Long> {


    List<BlockReleased> findByCompanyId(Long companyId);

    List<BlockReleased> findByCompanyIdAndTeamIdIn(Long companyId, List<Long> teamId);
}
