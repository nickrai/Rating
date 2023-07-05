package com.office.Rating.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.office.Rating.dto.Restaurant;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatingResponse {

    private Long ratingId;
    private Long customerId;
    private int rating;
    private String feedback;
    private Long restId;
    private Restaurant restaurant;
}
