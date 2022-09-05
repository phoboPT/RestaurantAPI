package com.example.restaurant.web;

import com.example.restaurant.model.AccountModel;
import com.example.restaurant.service.modelService.AccountService;
import com.example.restaurant.service.modelService.AccountServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/account", path = "/account")
public class AccountEndpoint {
    private final AccountService accountService;

    public AccountEndpoint(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping ("/create")
    @ExceptionHandler (AccountServiceImpl.AccountAlreadyExistsException.class)
    AccountModel create(@RequestBody @NotNull AccountModel accountModel) throws
                                                                         AccountServiceImpl.AccountNotFoundException {
        var address = accountModel.getAddressModel();
        return accountService.create(accountModel.getPassword(),
                                     accountModel.getUsername(),
                                     address.getStreet(),
                                     address.getCity(),
                                     address.getState(),
                                     address.getZip());
    }
    @GetMapping ("/count")
    long getCount() {
        return accountService.count();
    }
    @GetMapping ("/{id}")
    @ExceptionHandler (AccountServiceImpl.AccountNotFoundException.class)
    AccountModel getById(@PathVariable long id) throws AccountServiceImpl.AccountNotFoundException {
        return accountService.getById(id);
    }

}
