package com.example.restaurant.service;

import com.example.restaurant.model.Restaurant;
import com.example.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant create(String name) {
        checkIfExists(name);
        return restaurantRepository.save(new Restaurant(name));
    }
    private void checkIfExists(String name) {
        restaurantRepository.findAll()
                            .forEach(restaurant -> {
                                if (restaurant.getName()
                                              .equals(name)) {
                                    throw new RestaurantAlreadyExistsException();
                                }
                            });
    }

    @Override
    public long count() {
        return restaurantRepository.count();
    }

    @Override
    public Restaurant getById(long id) throws RestaurantNotFoundException {
        return restaurantRepository.findById(id)
                                   .orElseThrow(RestaurantNotFoundException::new);
    }

    public static class RestaurantNotFoundException extends RuntimeException {

    }
    public static class RestaurantAlreadyExistsException extends RuntimeException {
    }
}
