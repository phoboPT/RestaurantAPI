package com.example.restaurant.service;

import com.example.restaurant.model.Account;

public interface AccountService {

    Account createAccount(String password, String street, String city, String state, String zip);
    long count();

    Account getAccount (long id);



}
