package com.example.restaurant.service;

import com.example.restaurant.model.Account;
import com.example.restaurant.model.Waiter;

import java.util.Date;
public interface WaiterService {
    Waiter create(Date dateJoined, Account account, String name, String phoneNumber, String email);

    long count();

    Waiter getById(long id);
}
