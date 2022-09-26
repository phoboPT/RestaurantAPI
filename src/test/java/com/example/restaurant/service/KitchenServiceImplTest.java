package com.example.restaurant.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
public class KitchenServiceImplTest {
    @Autowired
    private KitchenService kitchenService;

    @Test
    public void createShouldSaveKitchen() {
        var count = kitchenService.count();
        var kitchen = kitchenService.create("Hells Kitchen");
        assertThat(kitchenService.count()).isGreaterThan(count);
        assertEquals(kitchen.getName(),
                     "Hells Kitchen");
    }

    @Test
    public void createShouldReturnAKitchen() {
        var kitchen = kitchenService.create("kitchen");
        assertThat(kitchen).isNotNull();
        assertThat(kitchen.getName()).isEqualTo("kitchen");
    }

    @Test
    public void createShouldThrowKitchenAlreadyExistsException() {
        kitchenService.create("hells");
        assertThrows(KitchenServiceImpl.KitchenAlreadyExistsException.class,
                     () -> kitchenService.create("hells"));
    }

    @Test
    public void getByIdShouldReturnAKitchen() {
        var kitchen = kitchenService.create("new kitchen");
        var searchedKitchen = kitchenService.getById(kitchen.getId());
        assertThat(searchedKitchen).isNotNull();
        assertEquals("new kitchen",
                     searchedKitchen.getName());
    }

    @Test
    public void getByIdShouldThrowKitchenNotFound() throws KitchenServiceImpl.KitchenNotFoundException {
        assertThrows(KitchenServiceImpl.KitchenNotFoundException.class,
                     () -> kitchenService.getById(23123));
    }

}
