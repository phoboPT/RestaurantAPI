package com.example.restaurant.service.modelService;

import com.example.restaurant.model.AccountModel;
import com.example.restaurant.model.ReceptionistModel;

import java.util.Date;

public interface ReceptionistService {

    ReceptionistModel create(Date dateJoined, AccountModel accountModel, String name, String phoneNumber, String email);

    long count();

    ReceptionistModel getById(long id);
}
