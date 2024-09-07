package com.example.RealEstateCRM.service;

import com.example.RealEstateCRM.model.Cab;
import java.util.List;

public interface CabService {
    Cab addCab(Cab cab);
    List<Cab> cabDetails();
    Cab updateCab(Long cabId, Cab cab);
    String deleteCabById(Long cabId);
    Cab getCabById(Long cabId);
}
