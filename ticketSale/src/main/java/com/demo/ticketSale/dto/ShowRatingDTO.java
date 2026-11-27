package com.demo.ticketSale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShowRatingDTO {
    private final Long showId;
    private final String title;
    private final Double averageRating;
    private final Long feedbackCount;
}
