package com.example.restaurant.service;

import com.example.restaurant.model.Restaurant;
public interface RestaurantService {

    Restaurant create(String name);

    long count();

    Restaurant getById(long id);
}
