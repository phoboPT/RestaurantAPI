package com.example.restaurant.services;

import com.example.restaurant.enums.AccountStatus;
import com.example.restaurant.exceptions.AccountNotFoundException;
import com.example.restaurant.model.Account;
import com.example.restaurant.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private AdressService adressService;


    public AccountServiceImpl(AccountRepository accountRepository, AdressService adressService) {
        this.accountRepository = accountRepository;
        this.adressService = adressService;
    }

    @Override
    public Account createAccount(String password, String street, String city, String state, String zip) {

        var adress = adressService.createAdress(street, city, state, zip);
        Account account = new Account(password, adress, AccountStatus.ACTIVE);
        this.accountRepository.save(account);
        return account;
    }

    @Override
    public long count() {
        return accountRepository.count();
    }

    @Override
    public Account getAccount(long id) throws AccountNotFoundException {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("account not found " + id));

    }


}
