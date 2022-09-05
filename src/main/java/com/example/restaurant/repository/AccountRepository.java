package com.example.restaurant.repository;

import com.example.restaurant.model.AccountModel;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountModel, Long> {

}

