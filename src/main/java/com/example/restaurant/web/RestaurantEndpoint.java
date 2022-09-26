package com.example.restaurant.web;

import com.example.restaurant.model.Restaurant;
import com.example.restaurant.service.RestaurantService;
import com.example.restaurant.service.RestaurantServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping (value = "/restaurant", path = "/restaurant")
public class RestaurantEndpoint {
    private final RestaurantService restaurantService;

    public RestaurantEndpoint(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping ("/create")
    public void create(@RequestBody Restaurant restaurant) {
        restaurantService.create(restaurant.getName());
    }

    @GetMapping ("/count")
    public long count() {
        return restaurantService.count();
    }

    @GetMapping ("/{id}")
    public Restaurant getById(@PathVariable long id) throws RestaurantServiceImpl.RestaurantNotFoundException {
        return restaurantService.getById(id);
    }
}
