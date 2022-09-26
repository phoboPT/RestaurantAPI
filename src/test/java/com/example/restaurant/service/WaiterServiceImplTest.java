package com.example.restaurant.service;

import com.example.restaurant.Builder.AccountDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
public class WaiterServiceImplTest {

    @Autowired private WaiterService waiterService;

    @Test
    public void createShouldSaveWaiter() {
        var name = "name1";
        var phone = "123123";
        var email = "email";
        var account = AccountDataBuilder.buildFullAccountWithUsername("Hugo");
        var countWaiters = waiterService.count();
        var waiter = waiterService.create(new Date(), account, name, phone, email);
        assertThat(waiterService.count()).isGreaterThan(countWaiters);
        assertEquals(waiter.getName(), name);
        assertEquals(waiter.getPhone(), phone);
        assertEquals(waiter.getEmail(), email);
        assertEquals(waiter.getAccount()
                           .getPassword(), account.getPassword());
        assertEquals(waiter.getAccount()
                           .getUsername(), account.getUsername());
        assertEquals(waiter.getAccount()
                           .getAddress()
                           .getStreet(), account.getAddress()
                                                .getStreet());
        assertEquals(waiter.getAccount()
                           .getAddress()
                           .getCity(), account.getAddress()
                                              .getCity());
        assertEquals(waiter.getAccount()
                           .getAddress()
                           .getZip(), account.getAddress()
                                             .getZip());

    }

    @Test
    public void createShouldReturnWaiter() {
        var name = "name2";
        var phone = "123123";
        var email = "email";
        var account = AccountDataBuilder.buildFullAccountWithUsername("Maria");
        var waiter = waiterService.create(new Date(), account, name, phone, email);
        assertEquals(waiter, waiterService.getById(waiter.getId()));
    }

    @Test
    public void findByIdShouldThrowWaiterNotFoundException() {
        assertThrows(WaiterServiceImpl.WaiterNotFoundException.class, () -> waiterService.getById(23123));
    }

    @Test
    public void findByIdShouldReturnWaiter() {
        var name = "name3";
        var phone = "123123";
        var email = "email";
        var account = AccountDataBuilder.buildFullAccountWithUsername("Marcos");
        var waiter = waiterService.create(new Date(), account, name, phone, email);
        assertEquals(waiter, waiterService.getById(waiter.getId()));
    }

    @Test
    public void countShouldReturnNumberOfWaiters() {

        assertThat(waiterService.count()).isGreaterThan(0);
    }
}
