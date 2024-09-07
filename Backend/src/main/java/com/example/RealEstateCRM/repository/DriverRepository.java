package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByDriverId(Long driverId);

}