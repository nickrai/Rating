package com.office.Rating.repository;

import com.office.Rating.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingsRepository extends JpaRepository<Ratings,Long> {
    Optional<Ratings> findById(Long ratingId);

    List<Ratings> findRatingByRestId(Long restId);

    List<Ratings> findRatingByCustomerId(Long customerId);
}
