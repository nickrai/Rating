package com.office.Rating.service;

import com.office.Rating.Client.RestaurantClient;
import com.office.Rating.dto.Restaurant;
import com.office.Rating.entity.RatingResponse;
import com.office.Rating.entity.Ratings;
import com.office.Rating.repository.RatingsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RatingsServiceImpl implements RatingsService{

    @Autowired
    private RatingsRepository ratingsRepository;

    @Autowired
    private RestaurantClient restaurantClient;

    @Override
    public Ratings create(Ratings ratings) {
        return ratingsRepository.save(ratings);
    }

    @Override
    public List<Ratings> getAll() {
        return ratingsRepository.findAll();
    }

    @Override
    public Ratings getById(Long ratingId) {
        return ratingsRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found for id : " + ratingId));
    }

    @Override
    public List<Ratings> getRatingByRestId(Long restId) {
        return ratingsRepository.findRatingByRestId(restId);
    }

    @Override
    public List<RatingResponse> getRatingByCustomerId(Long customerId) {
        List<Ratings> ratings = ratingsRepository.findRatingByCustomerId(customerId);
        Map<Long, Restaurant> restaurantMap = restaurantByRatingId(ratings);
        List<RatingResponse> ratingResponses = new ArrayList<>();
        for (Ratings rating : ratings) {
            RatingResponse ratingResponse = new RatingResponse();
            ratingResponse.setCustomerId(rating.getCustomerId());
            ratingResponse.setRatingId(rating.getRatingId());
            ratingResponse.setRating(rating.getRating());
            ratingResponse.setFeedback(rating.getFeedback());
            if (restaurantMap.containsKey(rating.getRestId())) {
                ratingResponse.setRestaurant(restaurantMap.get(rating.getRestId()));
            }
            ratingResponses.add(ratingResponse);
        }
        return ratingResponses;
    }

    private Map<Long, Restaurant> restaurantByRatingId(List<Ratings> ratings) {
        List<Long> restaurantIds = getRestaurantIds(ratings);
        List<Restaurant> restaurants = restaurantClient.getRestaurant(restaurantIds);
        return restaurants.stream()
                .collect(Collectors.toMap(Restaurant::getRestId, Function.identity()));
    }

    private static List<Long> getRestaurantIds(List<Ratings> ratings) {
        return ratings.stream()
                .map(Ratings::getRestId)
                .collect(Collectors.toList());
    }


}
