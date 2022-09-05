package com.example.restaurant.service.modelService;

import com.example.restaurant.model.CustomerModel;
import com.example.restaurant.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerModel create(String name, String email, String phone) {
        checkIfAlreadyExists(email);
        return customerRepository.save(new CustomerModel(new Date(), name, email, phone));
    }
    private void checkIfAlreadyExists(String email) {
        customerRepository.findAll().forEach(customer -> {
            if (customer.getEmail().equals(email)) {
                throw new CustomerAlreadyExistsException();
            }
        });
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public CustomerModel getById(long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public static class CustomerNotFoundException extends RuntimeException {
    }
    public static class CustomerAlreadyExistsException extends RuntimeException {
    }
}
