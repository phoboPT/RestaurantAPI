package com.example.restaurant.repository;

import com.example.restaurant.model.RestaurantModel;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<RestaurantModel, Long> {


}
