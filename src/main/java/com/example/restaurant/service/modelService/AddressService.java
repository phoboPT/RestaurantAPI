package com.example.restaurant.service.modelService;

import com.example.restaurant.model.AddressModel;

public interface AddressService {

    AddressModel create(String street, String city, String state, String zip);

    long count();

    AddressModel getById(long id);

}
