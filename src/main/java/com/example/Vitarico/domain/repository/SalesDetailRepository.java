package com.example.Vitarico.domain.repository;

import com.example.Vitarico.domain.entities.SalesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesDetailRepository extends JpaRepository<SalesDetail, Long> {
}
