package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.BookPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookPayRepository extends JpaRepository<BookPay,Long> {
    List<BookPay> findByBookingId(Long bookingId);
}
