package com.example.restaurant.service.modelService;

import com.example.restaurant.enums.AccountStatus;
import com.example.restaurant.model.AccountModel;
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
    public AccountModel create(String password, String username, String street, String city, String state, String zip) throws AccountAlreadyExistsException {
        var address = addressService.create(street, city, state, zip);
        AccountModel accountModel = new AccountModel(password, username, address, AccountStatus.ACTIVE);
        checkIfUserAlreadyExists(username);
        accountRepository.save(accountModel);
        return accountModel;
    }
    private void checkIfUserAlreadyExists(String username) {
        accountRepository.findAll().forEach(account -> {
            if (account.getUsername().equals(username)) {
                throw new AccountAlreadyExistsException();
            }
        });
    }

    @Override
    public long count() {
        return accountRepository.count();
    }

    @Override
    public AccountModel getById(long id) throws AccountNotFoundException {
        return accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
    }

    public static class AccountNotFoundException extends RuntimeException {

    }

    public static class AccountAlreadyExistsException extends RuntimeException {

    }
}
