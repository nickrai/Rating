package com.office.Rating.controller;

import com.office.Rating.entity.RatingResponse;
import com.office.Rating.entity.Ratings;
import com.office.Rating.service.RatingsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@AllArgsConstructor
public class RatingsController {

    @Autowired
    private RatingsServiceImpl ratingsServiceImpl;

    @PostMapping
    public Ratings create(@RequestBody Ratings ratings)
    {
        return ratingsServiceImpl.create(ratings);
    }
    @GetMapping
    public List<Ratings> getAll()
    {
        return ratingsServiceImpl.getAll();
    }

    @GetMapping("/{ratingId}")
   public Ratings getById(@PathVariable Long ratingId)
    {
    return ratingsServiceImpl.getById(ratingId);
    }

    @GetMapping("/restaurants/{restId}")
    public List<Ratings> getRatingByRestId(@PathVariable Long restId) {
        return ratingsServiceImpl.getRatingByRestId(restId);
    }

    @GetMapping("/customers/{customerId}")
    public List<RatingResponse> getRatingByCustomerId(@PathVariable Long customerId) {
        return ratingsServiceImpl.getRatingByCustomerId(customerId);

    }
}
