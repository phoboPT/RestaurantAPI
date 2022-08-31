package com.example.restaurant.service;

import com.example.restaurant.exception.AccountNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeMethod;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod");
        MockitoAnnotations.openMocks(this);
//
    }

    @Test
    public void accountRepositoryShouldSaveAccount() {
        var account=accountService.createAccount("password", "street", "city", "state", "zip");
        assertThat(account).isNotNull();

    }
    @Test
    public void accountRepositoryShouldReturnAccount() {
        var account=accountService.createAccount("password", "street", "city", "state", "zip");
        assertThat(account).isNotNull();
        assertEquals(accountService.getAccount(account.getId()), account);
    }

    @Test
    public void accountRepositoryShouldReturnAccountCount() {
        var account=accountService.createAccount("password", "street", "city", "state", "zip");
        assertThat(account).isNotNull();
        assertEquals(3, accountService.count());
    }

    @Test
    public void accountRepositoryShouldThrowAccountNotFoundException() {
        assertThrows(AccountNotFoundException.class, () -> accountService.getAccount(23123));
    }

    @Test
    public void accountRepositoryShouldThrowAccount() {
        assertThrows(AccountNotFoundException.class, () -> accountService.getAccount(23123));
    }
}