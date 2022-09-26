package com.example.restaurant.web;

import com.example.restaurant.model.Chef;
import com.example.restaurant.service.ChefServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
@RequestMapping (value = "/chef", path = "/chef")
public class ChefEndpoint {
    ChefServiceImpl chefService;

    public ChefEndpoint(ChefServiceImpl chefService) {
        this.chefService = chefService;
    }

    @RequestMapping ("/count")
    public long count() {
        return chefService.count();

    }

    @RequestMapping ("/{id}")
    public Chef getById(@PathVariable long id) throws ChefServiceImpl.ChefNotFoundException {
        return chefService.getById(id);
    }

    @RequestMapping ("/create")
    public Chef create(@RequestBody Chef chef) {
        return chefService.create(new Date(),
                                  chef.getAccount(),
                                  chef.getName(),
                                  chef.getPhone(),
                                  chef.getEmail());
    }

}
