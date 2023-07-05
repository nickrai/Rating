package com.office.Rating.Client;

import com.office.Rating.dto.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="restaurant", url = "http://localhost:8112/")
public interface RestaurantClient {
    @GetMapping("/restaurants")
    List<Restaurant> getRestaurant(@RequestParam List<Long> restId);
}
