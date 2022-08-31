package com.example.restaurant.repositories;

import com.example.restaurant.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

