package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.model.BlockReleased;
import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.repository.BlockReleasedRepository;
import com.example.RealEstateCRM.service.BlockReleasedService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockReleasedServiceClass implements BlockReleasedService
{
@Autowired
    BlockReleasedRepository blockReleasedRepository;

    @Override
    public BlockReleased addBlockReleased(BlockReleased blockReleased) {
        return blockReleasedRepository.save(blockReleased);

    }
    @Override
    public List<BlockReleased> getAllBlockReleasedDetails() {
        return blockReleasedRepository.findAll();
    }

    @Override
    public List<BlockReleased> getBlockReleasedByCompanyId(Long companyId) {
        List<BlockReleased> blockReleaseds = blockReleasedRepository.findByCompanyId(companyId);
        if (blockReleaseds.isEmpty()) {
            throw new EntityNotFoundException("BlockReleased not found for companyId: " + companyId);
        }
        return blockReleaseds;
    }

    @Override
    public List<BlockReleased> getBlockReleasedByCompanyIdAndTeamId(Long companyId, List<Long> teamId) {
        return blockReleasedRepository.findByCompanyIdAndTeamIdIn(companyId, teamId);
    }

}
