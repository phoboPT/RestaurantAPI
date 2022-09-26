package com.example.restaurant.service;

import com.example.restaurant.model.Account;

public interface AccountService {

    Account create(String password, String username, String street, String city, String state, String zip);

    Account create(Account account);

    long count();

    Account getById(long id);

}
