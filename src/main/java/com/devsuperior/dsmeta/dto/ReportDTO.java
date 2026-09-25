package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Seller;

import java.time.LocalDate;

public class ReportDTO {

    private Long id;
    private Double amount;
    private LocalDate date;
    private String sellerName;

    public ReportDTO(Long id, LocalDate date, String sellerName, Double amount) {
        this.id = id;
        this.date = date;
        this.sellerName = sellerName;
        this.amount = amount;

    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Long getId() {
        return id;
    }

}
