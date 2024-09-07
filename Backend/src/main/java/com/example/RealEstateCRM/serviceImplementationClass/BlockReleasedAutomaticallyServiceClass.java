package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.model.BlockReleasedAutomatically;
import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.repository.BlockReleasedAutomaticallyRepository;
import com.example.RealEstateCRM.service.BlockReleasedAutomaticallyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlockReleasedAutomaticallyServiceClass implements BlockReleasedAutomaticallyService {
    @Autowired
    BlockReleasedAutomaticallyRepository blockReleasedAutomaticallyRepository;

    @Override
    public BlockReleasedAutomatically addBlockReleasedAutomatically(BlockReleasedAutomatically blockReleasedAutomatically) {
        return blockReleasedAutomaticallyRepository.save(blockReleasedAutomatically);

    }
    @Override
    public List<BlockReleasedAutomatically> getAllBlockReleasedAutomaticallyDetails() {
        return blockReleasedAutomaticallyRepository.findAll();
    }

    @Override
    public List<BlockReleasedAutomatically> getBlockReleasedAutomaticallyByCompanyId(Long companyId) {
        List<BlockReleasedAutomatically> blockReleasedAutomatically = blockReleasedAutomaticallyRepository.findByCompanyId(companyId);
        if (blockReleasedAutomatically.isEmpty()) {
            throw new EntityNotFoundException("BlockReleasedAutomatically not found for companyId: " + companyId);
        }
        return blockReleasedAutomatically;
    }

    @Override
    public List<BlockReleasedAutomatically> getBlockReleasedAutomaticallyByCompanyIdAndTeamId(Long companyId, List<Long> teamId) {
        return blockReleasedAutomaticallyRepository.findByCompanyIdAndTeamIdIn(companyId, teamId);
    }

}
