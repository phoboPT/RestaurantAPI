package com.example.restaurant.service.modelService;

import com.example.restaurant.model.AccountModel;
import com.example.restaurant.model.ChefModel;

import java.util.Date;
public interface ChefService {

    ChefModel create(Date dateJoined, AccountModel accountModel, String name, String phoneNumber, String email);

    long count();

    ChefModel getById(long id);
}
