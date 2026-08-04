package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

public class ReportDTO {

    private Long id;
    private Double quantia;
    private LocalDate date;
    private String seller;

    public ReportDTO(LocalDate date, String seller) {
        this.date = date;
        this.seller = seller;

    }

    public LocalDate getDate() {
        return date;
    }

    public Double getQuantia() {
        return quantia;
    }

    public String getSeller() {
        return seller;
    }

}
