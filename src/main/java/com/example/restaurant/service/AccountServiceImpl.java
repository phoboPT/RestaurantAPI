package com.example.restaurant.service;

import com.example.restaurant.enums.AccountStatus;
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
    public Account create(String password, String username, String street, String city, String state, String zip) throws
                                                                                                                  AccountAlreadyExistsException {
        var address = addressService.create(street, city, state, zip);
        Account account = new Account(password, username, address, AccountStatus.ACTIVE);
        checkIfUserAlreadyExists(username);
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account create(Account account) throws AccountAlreadyExistsException {
        var address = addressService.create(account.getAddress()
                                                   .getStreet(), account.getAddress()
                                                                        .getCity(), account.getAddress()
                                                                                           .getState(),
                                            account.getAddress()
                                                   .getZip());
        checkIfUserAlreadyExists(account.getUsername());
        Account userAccount = new Account(account.getPassword(), account.getUsername(), address, AccountStatus.ACTIVE);
        accountRepository.save(userAccount);
        return userAccount;
    }
    @Override
    public long count() {
        return accountRepository.count();
    }
    @Override
    public Account getById(long id) throws AccountNotFoundException {
        return accountRepository.findById(id)
                                .orElseThrow(AccountNotFoundException::new);
    }
    private void checkIfUserAlreadyExists(String username) {
        accountRepository.findAll()
                         .forEach(account -> {
                             if (account.getUsername()
                                        .equals(username)) {
                                 throw new AccountAlreadyExistsException();
                             }
                         });
    }
    public static class AccountNotFoundException extends RuntimeException {

    }

    public static class AccountAlreadyExistsException extends RuntimeException {

    }
}
