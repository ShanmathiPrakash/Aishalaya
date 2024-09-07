package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.Blocks;
import com.example.RealEstateCRM.model.Booking;
import com.example.RealEstateCRM.model.VisitDetails;
import com.example.RealEstateCRM.service.BlocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blocks")
public class BlocksController
{
    @Autowired
    BlocksService blocksService;
    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotblocked')")
    @PostMapping("/addBlocks")
    public ResponseEntity<Blocks> addBlocks(@RequestBody Blocks blocks) {
        return new ResponseEntity<Blocks>(blocksService.addBlocks(blocks), HttpStatus.ACCEPTED);
    }
    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotblocked')")
    @GetMapping("/blocksDetails")
    public ResponseEntity<List<Blocks>> getAllBlocksDetails() {
        List<Blocks> blocks = blocksService.blocksDetails();
        return ResponseEntity.ok(blocks);
    }
    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotblocked')")
    @GetMapping("/getBlocksById/{blocksId}")
    public ResponseEntity<Blocks> getBlocksById(@PathVariable Long blocksId) {
        Blocks blocks = blocksService.getBlocksById(blocksId);
        return ResponseEntity.ok(blocks);
    }
    @GetMapping("/getBlocksByProjectId/{projectId}")
    public ResponseEntity<List<Blocks>> getBlocksByProjectId(@PathVariable Long projectId)
    {
       List<Blocks> blocks = blocksService.getBlocksByProjectId(projectId);
        return ResponseEntity.ok(blocks);
    }
    //    @PreAuthorize("@securityServiceImpl.isAccessible('plotblocked')")
    @PutMapping("/updateBlocks/{blocksId}")
    public ResponseEntity<Blocks> updateBlocks(@PathVariable Long blocksId, @RequestBody Blocks blocks) {
        return new ResponseEntity<Blocks>(blocksService.updateBlocks(blocksId,blocks), HttpStatus.ACCEPTED);

    }
    @GetMapping("/getByDateRange")
    public ResponseEntity<List<Blocks>> getByDateRange(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<Blocks> visitDetails = blocksService.getByDateRange(startDate, endDate);
        return ResponseEntity.ok(visitDetails);
    }
    @GetMapping("/getByCustomerNames")
    public ResponseEntity<List<Blocks>> getByCustomerNames(@RequestParam List<String> customerName) {
        List<Blocks> visitDetails = blocksService.getByCustomerNames(customerName);
        return ResponseEntity.ok(visitDetails);
    }
    @GetMapping("/getByPhoneNumbers")
    public ResponseEntity<List<Blocks>> getByPhoneNumbers(@RequestParam List<String> phoneNumber) {
        List<Blocks> visitDetails = blocksService.getByPhoneNumbers(phoneNumber);
        return ResponseEntity.ok(visitDetails);
    }
    @GetMapping("/getByEmployeeNames")
    public ResponseEntity<List<Blocks>> getByEmployeeNames(@RequestParam List<String> employeeName) {
        List<Blocks>  visitDetails = blocksService.getByEmployeeNames(employeeName);
        return ResponseEntity.ok(visitDetails);
    }
    @GetMapping("getBlockDetailsByVisitIdAndProjectName/{visitId}/{projectName}")
    public ResponseEntity<Optional<Blocks>> getBlockDetailsByVisitIdAndProjectName(@PathVariable Long visitId, @PathVariable String projectName) {
        Optional<Blocks> visitDetailOptional = Optional.ofNullable(blocksService.getBlockDetailsByVisitIdAndProjectName(visitId,projectName));
        return ResponseEntity.ok(visitDetailOptional);
    }

    //delete in block and add in blockReleased table

    @DeleteMapping("/deleteBlockById/{blockId}")
    public ResponseEntity<String> deleteBlockById(@PathVariable Long blockId) {
        return new ResponseEntity<String>(blocksService.deleteBlockById(blockId), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getServerTime")
    public String getServerTime() {
        // Get the current time in UTC format
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        String formattedTime = currentTime.format(formatter);

        return formattedTime;
    }

    @GetMapping("getBlockDetailsByVisitIdAndProjectNameAndPlotNumber/{visitId}/{projectName}/{plotNumber}")
    public ResponseEntity<Optional<Blocks>> getBlockDetailsByVisitIdAndProjectNameAndPlotNumber(@PathVariable Long visitId, @PathVariable String projectName,@PathVariable Long plotNumber) {
        Optional<Blocks> visitDetailOptional = Optional.ofNullable(blocksService.getBlockDetailsByVisitIdAndProjectNameAndPlotNumber(visitId,projectName,plotNumber));
        return ResponseEntity.ok(visitDetailOptional);
    }

    @GetMapping("/getBlocksByCompanyId/{companyId}")
    public ResponseEntity<List<Blocks>> getBlocksByCompanyId(@PathVariable Long companyId) {
        List<Blocks> blocks = blocksService.getBlocksByCompanyId(companyId);
        return ResponseEntity.ok(blocks);
    }

    @GetMapping("/companyAndTeamId/{companyId}/{teamId}")
    public List<Blocks> getBlocksByCompanyAndTeam(@PathVariable Long companyId, @PathVariable List<Long> teamId)
    {
        return blocksService.getBlocksByCompanyIdAndTeamId(companyId, teamId);
    }


    
}

