package com.example.restaurant.web;

import com.example.restaurant.model.KitchenModel;
import com.example.restaurant.service.modelService.KitchenService;
import com.example.restaurant.service.modelService.KitchenServiceImpl;
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
    public KitchenModel create(@RequestBody KitchenModel kitchen) {
        return kitchenService.create(kitchen.getName());
    }

    @GetMapping ("/count")
    public long count() {
        return kitchenService.count();
    }

    @GetMapping ("/{id}")
    public KitchenModel getById(@PathVariable long id) throws KitchenServiceImpl.KitchenNotFoundException {
        return kitchenService.getById(id);
    }
}
