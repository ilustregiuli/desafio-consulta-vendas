package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.ReportDTO;
import com.devsuperior.dsmeta.dto.SummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
    @Query( "SELECT new com.devsuperior.dsmeta.dto.ReportDTO(s.id, s.date, s.seller.name, s.amount) " +
            "FROM Sale s " +
            "WHERE s.date BETWEEN :minDate AND :maxDate " +
            "AND (:name IS NULL OR LOWER(s.seller.name) LIKE CONCAT('%',LOWER(:name),'%'))" )
    Page<ReportDTO> report(@Param("maxDate") LocalDate maxDate,
                           @Param("minDate") LocalDate minDate,
                           @Param("name") String name,
                           Pageable pageable);

    @Query( "SELECT new com.devsuperior.dsmeta.dto.SummaryDTO(s.seller.name, SUM(s.amount)) " +
            "FROM Sale s " +
            "WHERE s.date BETWEEN :minDate AND :maxDate " +
            "GROUP BY s.seller.name"
    )
    List<SummaryDTO> summary(@Param("maxDate") LocalDate maxDate,
                             @Param("minDate") LocalDate minDate);
}
