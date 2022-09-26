package com.example.restaurant.service;

import com.example.restaurant.model.Account;
import com.example.restaurant.model.Employee;
import com.example.restaurant.model.Manager;
public interface ManagerService {

    Manager create(String name, Account account, String email, String phone);

    long count();

    Manager getById(long id);

    Employee addEmployee(String name, Account account, String email, String phone, String type);
}
