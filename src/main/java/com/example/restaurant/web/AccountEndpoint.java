package com.example.restaurant.web;

import com.example.restaurant.configuration.LoadDatabase;
import com.example.restaurant.exception.AccountNotFoundException;
import com.example.restaurant.model.Account;
import com.example.restaurant.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/account",path = "/account")
public class AccountEndpoint {
    private final AccountService accountService;
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    public AccountEndpoint(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")

    Account createAccount(@RequestBody Account account) {
        log.info("password: " + account );

        return accountService.createAccount(account.getPassword(), account.getAddress().getStreet(), account.getAddress().getCity(), account.getAddress().getState(), account.getAddress().getZip());
    }

    @GetMapping("/count")
    long getAccountsCount() {
        return accountService.count();
    }

    @GetMapping("/{id}")
    Account getAccount(@PathVariable long id) throws AccountNotFoundException {
        return accountService.getAccount(id);
    }
}
