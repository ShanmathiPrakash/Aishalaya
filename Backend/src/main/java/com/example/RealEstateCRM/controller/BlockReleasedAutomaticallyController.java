package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.BlockReleased;
import com.example.RealEstateCRM.model.BlockReleasedAutomatically;
import com.example.RealEstateCRM.service.BlockReleasedAutomaticallyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/blockReleasedAutomatically")
@Controller
public class BlockReleasedAutomaticallyController {

    @Autowired
    BlockReleasedAutomaticallyService blockReleasedAutomaticallyService;


    @PostMapping("/addBlocksReleasedAutometically")
    public ResponseEntity<BlockReleasedAutomatically> addBlockReleasedAutomatically(@RequestBody BlockReleasedAutomatically blockReleasedAutometically) {
        return new ResponseEntity<BlockReleasedAutomatically>(blockReleasedAutomaticallyService.addBlockReleasedAutomatically(blockReleasedAutometically), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllBlockReleasedAutaticallyDetails")
    public ResponseEntity<List<BlockReleasedAutomatically>> getAllBlockReleasedAutomaticallyDetails() {
        List<BlockReleasedAutomatically> blocks = blockReleasedAutomaticallyService.getAllBlockReleasedAutomaticallyDetails();
        return ResponseEntity.ok(blocks);
    }

    @GetMapping("/getBlockReleasedAutomaticallyByCompanyId/{companyId}")
    public ResponseEntity<List<BlockReleasedAutomatically>> getBlockReleasedAutomaticallyByCompanyId(@PathVariable Long companyId) {
        List<BlockReleasedAutomatically> blockReleasedAutomatically = blockReleasedAutomaticallyService.getBlockReleasedAutomaticallyByCompanyId(companyId);
        return ResponseEntity.ok(blockReleasedAutomatically);
    }

    @GetMapping("/companyAndTeamId/{companyId}/{teamId}")
    public List<BlockReleasedAutomatically> getBlockReleasedAutomaticallyByCompanyAndTeam(@PathVariable Long companyId, @PathVariable List<Long> teamId)
    {
        return blockReleasedAutomaticallyService.getBlockReleasedAutomaticallyByCompanyIdAndTeamId(companyId, teamId);
    }
}
