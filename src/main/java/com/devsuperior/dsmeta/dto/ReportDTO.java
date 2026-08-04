package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

public class ReportDTO {

    private Long id;
    private Double quantia;
    private LocalDate date;

    private SellerDTO seller;

    public ReportDTO(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getQuantia() {
        return quantia;
    }

    public SellerDTO getSeller() {
        return seller;
    }

}
