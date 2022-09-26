package com.example.restaurant.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
public class RestaurantServiceImplTest {
    @Autowired private RestaurantService restaurantService;

    @Test
    public void createShouldSaveRestaurant() {
        var countRestaurants = restaurantService.count();
        var restaurant = restaurantService.create("test");
        assertThat(restaurantService.count()).isGreaterThan(countRestaurants);
        assertEquals(restaurant.getName(), "test");
    }

    @Test
    public void createShouldThrowRestaurantAlreadyExistsException() {
        restaurantService.create("restaurant");
        assertThrows(RestaurantServiceImpl.RestaurantAlreadyExistsException.class,
                     () -> restaurantService.create("restaurant"));
    }

    @Test
    public void createShouldReturnRestaurant() {
        var restaurant = restaurantService.create("Mac");
        assertEquals(restaurant, restaurantService.getById(restaurant.getId()));
    }

    @Test
    public void findByIdShouldThrowRestaurantNotFoundException() {
        assertThrows(RestaurantServiceImpl.RestaurantNotFoundException.class, () -> restaurantService.getById(23123));
    }

    @Test
    public void findByIdShouldReturnRestaurant() {
        var restaurant = restaurantService.create("MacDonald's");
        assertEquals(restaurant, restaurantService.getById(restaurant.getId()));
    }

    @Test
    public void countShouldReturnNumberOfRestaurants() {
        restaurantService.create("Macs");
        assertThat(restaurantService.count()).isGreaterThan(0L);
    }

}
