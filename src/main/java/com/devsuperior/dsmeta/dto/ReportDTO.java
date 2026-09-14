package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Seller;

import java.time.LocalDate;

public class ReportDTO {

    private Long id;
    private Double quantia;
    private LocalDate date;
    private Seller seller;

    public ReportDTO(Long id, LocalDate date, Seller seller, Double quantia) {
        this.id = id;
        this.date = date;
        this.seller = seller;
        this.quantia = quantia;

    }

    public LocalDate getDate() {
        return date;
    }

    public Double getQuantia() {
        return quantia;
    }

    public Seller getSeller() {
        return seller;
    }

    public Long getId() {
        return id;
    }

}
