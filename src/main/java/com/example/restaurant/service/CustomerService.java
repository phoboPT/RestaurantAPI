package com.example.restaurant.service;

import com.example.restaurant.model.Customer;
public interface CustomerService {

    Customer create(String name,
                    String email,
                    String phone);

    long count();

    Customer getById(long id);

}
