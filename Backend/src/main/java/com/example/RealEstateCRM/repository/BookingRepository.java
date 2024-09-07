package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    Optional<Booking> findByCustomerId(Long customerId);

    Optional<Booking> findByBlockId(String blockId);

    Optional<Booking> findTopByPlotNumberAndBalanceOrderByBookingIdDesc(Long plotNumber, double v);

    List<Booking> findByCompanyId(Long companyId);

    List<Booking> findByCompanyIdAndTeamIdIn(Long companyId, List<Long> teamId);

    List<Booking> findByCompanyIdAndBalance(Long companyId, Double balance);

    List<Booking> findByCompanyIdAndTeamIdInAndBalance(Long companyId, List<Long> teamId, Double balance);

    List<Booking> findByCompanyIdAndBalanceNot(Long companyId, Double balance);

    List<Booking> findByCompanyIdAndTeamIdInAndBalanceNot(Long companyId, List<Long> teamId, Double balance);

}
