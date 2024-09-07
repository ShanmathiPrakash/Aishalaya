package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.BookChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookChangeRepository extends JpaRepository<BookChange,Long> {
}
