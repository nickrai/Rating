package com.office.Rating.service;

import com.office.Rating.entity.RatingResponse;
import com.office.Rating.entity.Ratings;

import java.util.List;

public interface RatingsService {
    Ratings create(Ratings ratings);

    List<Ratings> getAll();

    Ratings getById(Long ratingId);

    List<Ratings> getRatingByRestId(Long restId);

    List<RatingResponse> getRatingByCustomerId(Long customerId);
}
