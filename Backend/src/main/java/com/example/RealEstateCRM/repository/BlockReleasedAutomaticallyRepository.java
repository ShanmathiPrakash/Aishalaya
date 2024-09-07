package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.BlockReleasedAutomatically;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockReleasedAutomaticallyRepository extends JpaRepository<BlockReleasedAutomatically,Long> {
     List<BlockReleasedAutomatically> findByCompanyId(Long companyId);

    List<BlockReleasedAutomatically> findByCompanyIdAndTeamIdIn(Long companyId, List<Long> teamId);
}
