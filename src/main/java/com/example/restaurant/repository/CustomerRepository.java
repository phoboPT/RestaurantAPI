package com.example.restaurant.repository;

import com.example.restaurant.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {

}

