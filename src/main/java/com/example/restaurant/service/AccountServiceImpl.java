package com.example.restaurant.service;

import com.example.restaurant.enums.AccountStatus;
import com.example.restaurant.exception.AccountNotFoundException;
import com.example.restaurant.model.Account;
import com.example.restaurant.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AddressService addressService;


    public AccountServiceImpl(AccountRepository accountRepository, AddressService addressService) {
        this.accountRepository = accountRepository;
        this.addressService = addressService;
    }

    @Override
    public Account createAccount(String password, String street, String city, String state, String zip) {
        var address = addressService.createAddress(street, city, state, zip);
        Account account = new Account(password, address, AccountStatus.ACTIVE);
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
