package com.example.RealEstateCRM.serviceImplementationClass;

import com.example.RealEstateCRM.model.Cab;
import com.example.RealEstateCRM.repository.CabRepository;
import com.example.RealEstateCRM.service.CabService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabServiceClass implements CabService {

    @Autowired
    CabRepository cabRepository;
    @Override
    public Cab addCab(Cab cab) {
        return cabRepository.save(cab);
    }
    @Override
    public List<Cab> cabDetails() {
        return cabRepository.findAll();
    }
    @Override
    public Cab updateCab(Long cabId, Cab cab) {
        Optional<Cab> ans=cabRepository.findById(cabId);
        Cab cab1=ans.get();
        cab1.setCabName(cab.getCabName());
        cab1.setEmployeeName(cab.getEmployeeName());
        cab1.setDepartment(cab.getDepartment());
        cab1.setVehicleType(cab.getVehicleType());
        return cabRepository.save(cab1);
    }
    @Override
    public String deleteCabById(Long cabId) {
        Optional<Cab> myData = cabRepository.findById(cabId);
        if (myData.isPresent()) {
            cabRepository.deleteById(cabId);
            return "Cab Deleted...Successfully...";
        }
        return "Cab Deletion...Failed...";
    }
    @Override
    public Cab getCabById(Long cabId) {
        return cabRepository.findById(cabId)
                .orElseThrow(() -> new EntityNotFoundException("Cab not found with cabId: " + cabId));
    }
}
