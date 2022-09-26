package com.example.restaurant.service;

import com.example.restaurant.model.Account;
import com.example.restaurant.model.Receptionist;

import java.util.Date;

public interface ReceptionistService {

    Receptionist create(Date dateJoined,
                        Account account,
                        String name,
                        String phoneNumber,
                        String email);

    long count();

    Receptionist getById(long id);
}
