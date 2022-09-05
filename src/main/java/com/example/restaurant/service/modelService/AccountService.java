package com.example.restaurant.service.modelService;

import com.example.restaurant.model.AccountModel;

public interface AccountService {

    AccountModel create(String password, String username, String street, String city, String state, String zip);

    long count();

    AccountModel getById(long id);

}
