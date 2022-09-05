package com.example.restaurant.service.modelService;

import com.example.restaurant.model.CustomerModel;
public interface CustomerService {

    CustomerModel create(String name, String email, String phone);

    long count();

    CustomerModel getById(long id);

}
