package com.example.restaurant.services;

import com.example.restaurant.model.Adress;

public interface AdressService {

    public Adress createAdress(String street, String city, String state, String zip);

    public long count();



}
