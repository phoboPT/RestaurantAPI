package com.example.restaurant.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
public class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;

    @Test
    public void creatShouldSaveACustomer() {
        var customerCount = customerService.count();
        var customer = customerService.create("Hugo",
                                              "email@email.pt",
                                              "7523435235");
        assertThat(customerCount).isLessThan(customerService.count());
        assertEquals(customer.getName(),
                     "Hugo");
        assertEquals(customer.getEmail(),
                     "email@email.pt");
        assertEquals(customer.getPhone(),
                     "7523435235");
    }

    @Test
    public void createShouldReturnACustomer() {
        var customer = customerService.create("Hugo",
                                              "email1@email.pt",
                                              "7523435235");
        assertThat(customer).isNotNull();
    }

    @Test
    public void createShouldThrowCustomerAlreadyExistsException() {
        customerService.create("Hugo",
                               "email2@email.pt",
                               "7523435235");
        assertThrows(CustomerServiceImpl.CustomerAlreadyExistsException.class,
                     () -> customerService.create("Hugo",
                                                  "email2@email.pt",
                                                  "7523435235"));
    }

}
