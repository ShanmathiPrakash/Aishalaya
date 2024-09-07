package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.BookCancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCancelRepository extends JpaRepository<BookCancel,Long> {


    List<BookCancel> findByCompanyId(Long companyId);

    List<BookCancel> findByCompanyIdAndTeamIdIn(Long companyId, List<Long> teamId);
}
