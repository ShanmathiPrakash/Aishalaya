package com.example.RealEstateCRM.controller;

import com.example.RealEstateCRM.model.Cab;
import com.example.RealEstateCRM.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cab")
public class CabController {
    @Autowired
    CabService cabService;
    @PostMapping("/addCab")
    public ResponseEntity<Cab> addCab(@RequestBody Cab cab) {
        return new ResponseEntity<Cab>(cabService.addCab(cab), HttpStatus.ACCEPTED);
    }
    @GetMapping("/cabDetails")
    public ResponseEntity<List<Cab>> getAllCabDetails() {
        List<Cab> cabs = cabService.cabDetails();
        return ResponseEntity.ok(cabs);
    }
    @GetMapping("/getCabById/{cabId}")
    public ResponseEntity<Cab> getCabById(@PathVariable Long cabId) {
        Cab cab = cabService.getCabById(cabId);
        return ResponseEntity.ok(cab);
    }
    @PutMapping("/updateCab/{id}")
    public ResponseEntity<Cab> updateCab(@PathVariable Long cabId, @RequestBody Cab cab) {

        return new ResponseEntity<Cab>(cabService.updateCab(cabId,cab), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteCabById/{id}")
    public ResponseEntity<String> deleteCabById(@PathVariable Long id) {
        return new ResponseEntity<String>(cabService.deleteCabById(id), HttpStatus.ACCEPTED);
    }
}
