package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.ReportDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import org.springframework.data.domain.Pageable;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query( "SELECT new com.devsuperior.dsmeta.dto.ReportDTO " +
            "FROM Sale s" +

    )
    Page<ReportDTO> report(LocalDate maxDate, LocalDate minDate, String name, Pageable pageable);

}
