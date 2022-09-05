package com.example.restaurant.service.modelService;

import com.example.restaurant.model.AccountModel;
import com.example.restaurant.model.ManagerModel;
public interface ManagerService {

    ManagerModel create(String name, AccountModel account, String email, String phone);

    long count();

    ManagerModel getById(long id);
}
