package com.example.restaurant.service;

import com.example.restaurant.model.Address;

public interface AddressService {

    Address create(String street,
                   String city,
                   String state,
                   String zip);

    long count();

    Address getById(long id);

}
