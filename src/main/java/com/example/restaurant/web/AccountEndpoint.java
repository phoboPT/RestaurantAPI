package com.example.restaurant.web;

import com.example.restaurant.configuration.LoadDatabase;
import com.example.restaurant.exceptions.AccountNotFoundException;
import com.example.restaurant.model.Account;
import com.example.restaurant.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountEndpoint {
    private final AccountService accountService;
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    public AccountEndpoint(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/createAccount")

    Account createAccount(@RequestBody Account account) {
        log.info("password: " + account );

        return accountService.createAccount(account.getPassword(), account.getAdress().getStreet(), account.getAdress().getCity(), account.getAdress().getState(), account.getAdress().getZip());
    }

    @GetMapping("/accountsCount")
    long getAccountsCount() {
        return accountService.count();
    }

    @GetMapping("/accounts/{id}")
    Account getAccount(@PathVariable long id) throws AccountNotFoundException {
        return accountService.getAccount(id);
    }
}
