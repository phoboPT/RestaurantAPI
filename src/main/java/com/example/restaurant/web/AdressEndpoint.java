package com.example.restaurant.web;

import com.example.restaurant.model.Adress;
import com.example.restaurant.services.AdressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdressEndpoint {
    private AdressService adressService;

    public AdressEndpoint(AdressService adressService) {
        this.adressService = adressService;
    }
    @PostMapping("/createAdress")
    public Adress createAdress(@RequestBody Adress adress) {
        return adressService.createAdress(adress.getStreet(), adress.getCity(), adress.getState(), adress.getZip());
    }



}
