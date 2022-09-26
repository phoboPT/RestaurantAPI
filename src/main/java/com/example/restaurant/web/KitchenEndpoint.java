package com.example.restaurant.web;

import com.example.restaurant.model.Kitchen;
import com.example.restaurant.service.KitchenService;
import com.example.restaurant.service.KitchenServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping (value = "/kitchen", path = "/kitchen")
public class KitchenEndpoint {
    private final KitchenService kitchenService;

    public KitchenEndpoint(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }
    @PostMapping ("/create")
    public Kitchen create(@RequestBody Kitchen kitchen) {
        return kitchenService.create(kitchen.getName());
    }

    @GetMapping ("/count")
    public long count() {
        return kitchenService.count();
    }

    @GetMapping ("/{id}")
    public Kitchen getById(@PathVariable long id) throws KitchenServiceImpl.KitchenNotFoundException {
        return kitchenService.getById(id);
    }
}
