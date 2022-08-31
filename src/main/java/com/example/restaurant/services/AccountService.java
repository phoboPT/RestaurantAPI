package com.example.restaurant.services;

import com.example.restaurant.enums.AccountStatus;
import com.example.restaurant.model.Account;
import com.example.restaurant.model.Adress;

public interface AccountService {

    public Account createAccount(String password, String street, String city, String state, String zip);
    public long count();

    public Account getAccount (long id);



}
