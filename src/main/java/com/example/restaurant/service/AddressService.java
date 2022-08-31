package com.example.restaurant.service;

import com.example.restaurant.model.Address;

public interface AddressService {

     Address createAddress(String street, String city, String state, String zip);


     long count();

    Address getAddress(long id);



}
