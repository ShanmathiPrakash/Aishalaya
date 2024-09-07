package com.example.RealEstateCRM.repository;

import com.example.RealEstateCRM.model.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListRepository extends JpaRepository<BookList,Long> {
}
