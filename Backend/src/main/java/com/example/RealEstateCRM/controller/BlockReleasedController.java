package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.BlockReleased;
import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.service.BlockReleasedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blockReleasedManually")
public class BlockReleasedController {
    @Autowired
    BlockReleasedService blockReleasedService;

    @PostMapping("/addBlocksReleased")
    public ResponseEntity<BlockReleased> addBlockReleased(@RequestBody BlockReleased blockReleased) {
        return new ResponseEntity<BlockReleased>(blockReleasedService.addBlockReleased(blockReleased), HttpStatus.ACCEPTED);
    }
    @GetMapping("/blockReleasedDetails")
    public ResponseEntity<List<BlockReleased>> getAllBlockReleasedDetails() {
        List<BlockReleased> blocks = blockReleasedService.getAllBlockReleasedDetails();
        return ResponseEntity.ok(blocks);
    }

    @GetMapping("/getBlockReleasedByCompanyId/{companyId}")
    public ResponseEntity<List<BlockReleased>> getBlockReleasedByCompanyId(@PathVariable Long companyId) {
        List<BlockReleased> blockReleaseds = blockReleasedService.getBlockReleasedByCompanyId(companyId);
        return ResponseEntity.ok(blockReleaseds);
    }

    @GetMapping("/companyAndTeamId/{companyId}/{teamId}")
    public List<BlockReleased> getBlockReleasedByCompanyAndTeam(@PathVariable Long companyId, @PathVariable List<Long> teamId)
    {
        return blockReleasedService.getBlockReleasedByCompanyIdAndTeamId(companyId, teamId);
    }

}
