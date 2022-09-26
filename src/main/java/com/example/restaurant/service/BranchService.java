package com.example.restaurant.service;

import com.example.restaurant.model.Branch;
public interface BranchService {

    Branch create(String name);

    long count();

    Branch getById(long id);
}
