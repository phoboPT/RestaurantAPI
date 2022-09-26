package com.example.restaurant.service;

import com.example.restaurant.model.Kitchen;
public interface KitchenService {
    Kitchen create(String name);

    long count();

    Kitchen getById(long id);
}
