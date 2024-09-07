package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyModelRepository extends JpaRepository<Company,Long> {
    Company findBycompanyId(Long companyId);

    Optional<Company> findByCompanyName(String companyName);


    Optional<Company> findByCinNo(String cinNo);
}
