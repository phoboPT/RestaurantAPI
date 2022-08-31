package com.example.restaurant.web;

import com.example.restaurant.model.Address;
import com.example.restaurant.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdressEndpoint {
    private final AddressService addressService;

    public AdressEndpoint(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping("/createAdress")
    public Address createAdress(@RequestBody Address address) {
        return addressService.createAddress(address.getStreet(), address.getCity(), address.getState(), address.getZip());
    }

    @GetMapping("/adressCount")
    public long getAdressCount() {
        return addressService.count();
    }



}
