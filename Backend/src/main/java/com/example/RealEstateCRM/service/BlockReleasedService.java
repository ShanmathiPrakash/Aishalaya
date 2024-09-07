package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.BlockReleased;
import com.example.RealEstateCRM.model.Blocks;

import java.util.List;

public interface BlockReleasedService {
    BlockReleased addBlockReleased(BlockReleased blockReleased);
    List<BlockReleased> getAllBlockReleasedDetails();


    List<BlockReleased> getBlockReleasedByCompanyId(Long companyId);

    List<BlockReleased> getBlockReleasedByCompanyIdAndTeamId(Long companyId, List<Long> teamId);
}
