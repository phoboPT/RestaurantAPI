package com.example.restaurant.service.modelService;

import com.example.restaurant.model.RestaurantModel;
public interface RestaurantService {

    RestaurantModel create(String name);

    long count();

    RestaurantModel getById(long id);
}
