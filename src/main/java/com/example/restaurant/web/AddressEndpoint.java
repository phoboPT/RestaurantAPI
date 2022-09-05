package com.example.restaurant.web;

import com.example.restaurant.model.AddressModel;
import com.example.restaurant.service.modelService.AddressService;
import com.example.restaurant.service.modelService.AddressServiceImpl;
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
    public AddressModel createAddress(@RequestBody AddressModel addressModel) {
        return addressService.create(addressModel.getStreet(), addressModel.getCity(), addressModel.getState(), addressModel.getZip());
    }

    @GetMapping ("/count")
    public long getAddressCount() {
        return addressService.count();
    }

    @GetMapping ("/{id}")
    public AddressModel getAddress(@PathVariable long id) throws AddressServiceImpl.AddressNotFoundException {
        return addressService.getById(id);
    }
}
