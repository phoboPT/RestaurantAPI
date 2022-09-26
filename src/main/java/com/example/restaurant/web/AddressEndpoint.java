package com.example.restaurant.web;

import com.example.restaurant.model.Address;
import com.example.restaurant.service.AddressService;
import com.example.restaurant.service.AddressServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/address", path = "/address")
public class AddressEndpoint {
    private final AddressService addressService;

    public AddressEndpoint(AddressService addressService) {

        this.addressService = addressService;
    }

    @PostMapping ("/create")
    public Address createAddress(@RequestBody Address address) {
        return addressService.create(address.getStreet(),
                                     address.getCity(),
                                     address.getState(),
                                     address.getZip());
    }

    @GetMapping ("/count")
    public long getAddressCount() {
        return addressService.count();
    }

    @GetMapping ("/{id}")
    public Address getAddress(@PathVariable long id) throws AddressServiceImpl.AddressNotFoundException {
        return addressService.getById(id);
    }
}
