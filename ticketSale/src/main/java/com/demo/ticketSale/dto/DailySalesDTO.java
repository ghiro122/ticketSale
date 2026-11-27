package com.demo.ticketSale.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DailySalesDTO {
    private final LocalDate date;
    private final Long ticketsSold;

    public DailySalesDTO(Integer year, Integer month, Integer day, Long ticketsSold) {
        this.date = LocalDate.of(year, month, day);
        this.ticketsSold = ticketsSold;
    }
}
