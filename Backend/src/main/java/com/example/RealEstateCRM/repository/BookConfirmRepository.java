package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.BookConfirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookConfirmRepository extends JpaRepository<BookConfirm,Long>
{


    List<BookConfirm> findByCompanyId(Long companyId);

    List<BookConfirm> findByCompanyIdAndTeamIdIn(Long companyId, List<Long> teamId);
}
