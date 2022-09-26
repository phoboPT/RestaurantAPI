package com.example.restaurant.service;

import com.example.restaurant.model.Account;
import com.example.restaurant.model.Waiter;
import com.example.restaurant.repository.WaiterRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class WaiterServiceImpl implements WaiterService {
    private final WaiterRepository waiterRepository;
    private final AccountService accountService;
    public WaiterServiceImpl(WaiterRepository waiterRepository, AccountService accountService) {
        this.waiterRepository = waiterRepository;
        this.accountService = accountService;
    }

    @Override
    public Waiter create(Date dateJoined, Account account, String name, String phoneNumber, String email) {

        var userAccount = accountService.create(account);

        return waiterRepository.save(new Waiter(dateJoined, userAccount, name, phoneNumber, email));
    }
    @Override
    public long count() {
        return waiterRepository.count();
    }
    @Override
    public Waiter getById(long id) {
        return waiterRepository.findById(id)
                               .orElseThrow(WaiterNotFoundException::new);
    }
    public static class WaiterNotFoundException extends RuntimeException {

    }

}
