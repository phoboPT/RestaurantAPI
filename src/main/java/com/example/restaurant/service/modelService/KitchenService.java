package com.example.restaurant.service.modelService;

import com.example.restaurant.model.KitchenModel;
public interface KitchenService {
    KitchenModel create(String name);

    long count();

    KitchenModel getById(long id);
}
