package com.example.restaurant.service;

import com.example.restaurant.service.modelService.AccountService;
import com.example.restaurant.service.modelService.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void accountRepositoryShouldSaveAccount() {
        var count = accountService.count();
        var account = accountService.create("password",
                                            "hugo",
                                            "street",
                                            "city",
                                            "state",
                                            "zip");
        assertThat(accountService.count()).isGreaterThan(count);
        assertEquals(account.getPassword(),
                     "password");
        assertEquals(account.getUsername(),
                     "hugo");
        assertEquals(account.getAddressModel()
                            .getStreet(),
                     "street");
        assertEquals(account.getAddressModel()
                            .getCity(),
                     "city");
        assertEquals(account.getAddressModel()
                            .getState(),
                     "state");
        assertEquals(account.getAddressModel()
                            .getZip(),
                     "zip");

    }

    @Test
    public void accountRepositoryShouldReturnAccount() {
        var account = accountService.create("password",
                                            "Jorge",
                                            "street",
                                            "city",
                                            "state",
                                            "zip");
        assertThat(account).isNotNull();
        assertEquals(accountService.getById(account.getId()),
                     account);
    }

    @Test
    public void accountRepositoryShouldThrowExceptionIfAlreadyExists() {
        assertThrows(AccountServiceImpl.AccountAlreadyExistsException.class,
                     () -> accountService.create("password",
                                                 "Jorge",
                                                 "street",
                                                 "city",
                                                 "state",
                                                 "zip"));
    }

    @Test
    public void accountRepositoryShouldReturnAccountCount() {
        assertThat(accountService.count()).isGreaterThan(0);
    }

    @Test
    public void accountRepositoryShouldThrowAccountNotFoundException() {
        assertThrows(AccountServiceImpl.AccountNotFoundException.class,
                     () -> accountService.getById(23123));
    }

}