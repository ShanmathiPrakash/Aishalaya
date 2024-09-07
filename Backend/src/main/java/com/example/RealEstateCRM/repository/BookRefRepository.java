package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.BookRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRefRepository extends JpaRepository<BookRef,Long> {
}
