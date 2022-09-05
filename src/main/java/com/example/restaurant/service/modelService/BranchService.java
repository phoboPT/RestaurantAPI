package com.example.restaurant.service.modelService;

import com.example.restaurant.model.BranchModel;
public interface BranchService {

    BranchModel create(String name);

    long count();

    BranchModel getById(long id);
}
