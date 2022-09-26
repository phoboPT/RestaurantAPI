package com.example.restaurant.service;

import com.example.restaurant.model.Account;
import com.example.restaurant.model.Chef;

import java.util.Date;
public interface ChefService {

    Chef create(Date dateJoined,
                Account account,
                String name,
                String phoneNumber,
                String email);

    long count();

    Chef getById(long id);
}
