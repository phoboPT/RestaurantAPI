package com.example.restaurant.repositories;

import com.example.restaurant.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}

