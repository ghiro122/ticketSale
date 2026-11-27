package com.demo.ticketSale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class PerformanceOccupancyDTO {

    private final Long performanceId;
    private final String showTitle;
    private final Instant startsAt;
    private final Long totalSeats;
    private final Long soldSeats;
}
