package com.example.restaurant.web;

import com.example.restaurant.model.CustomerModel;
import com.example.restaurant.service.modelService.CustomerService;
import com.example.restaurant.service.modelService.CustomerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping (value = "/customer", path = "/customer")
public class CustomerEndpoint {
    private final CustomerService customerService;

    public CustomerEndpoint(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping ("/count")
    public long count() {
        return customerService.count();
    }

    @GetMapping ("/{id}")
    public CustomerModel getById(@PathVariable long id) throws CustomerServiceImpl.CustomerNotFoundException {
        return customerService.getById(id);
    }

    @PostMapping ("/create")
    public CustomerModel create(@RequestBody CustomerModel customerModel) {
        return customerService.create(customerModel.getName(),
                                      customerModel.getEmail(),
                                      customerModel.getPhone());
    }
}
