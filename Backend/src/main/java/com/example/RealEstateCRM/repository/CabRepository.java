package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab,Long> {
}
