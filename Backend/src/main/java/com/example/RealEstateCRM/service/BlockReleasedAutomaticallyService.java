package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.BlockReleasedAutomatically;

import java.util.List;

public interface BlockReleasedAutomaticallyService {
    BlockReleasedAutomatically addBlockReleasedAutomatically(BlockReleasedAutomatically blockReleasedAutomatically);
    List<BlockReleasedAutomatically> getAllBlockReleasedAutomaticallyDetails();


    List<BlockReleasedAutomatically> getBlockReleasedAutomaticallyByCompanyId(Long companyId);

    List<BlockReleasedAutomatically> getBlockReleasedAutomaticallyByCompanyIdAndTeamId(Long companyId, List<Long> teamId);
}