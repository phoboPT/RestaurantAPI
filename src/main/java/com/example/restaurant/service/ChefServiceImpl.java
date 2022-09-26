package com.example.restaurant.service;

import com.example.restaurant.model.Account;
import com.example.restaurant.model.Chef;
import com.example.restaurant.repository.ChefRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ChefServiceImpl implements ChefService {
    private final ChefRepository chefRepository;
    private final AccountServiceImpl accountService;
    public ChefServiceImpl(ChefRepository chefRepository, AccountServiceImpl accountService) {
        this.chefRepository = chefRepository;
        this.accountService = accountService;

    }

    @Override
    public Chef create(Date dateJoined, Account account, String name, String phoneNumber, String email) throws
                                                                                                        ChefAlreadyExistsException {
        checkIfChefExists(email);
        var userAccount = accountService.create(account);
        return chefRepository.save(new Chef(dateJoined, userAccount, name, phoneNumber, email));
    }
    private void checkIfChefExists(String email) {
        chefRepository.findAll()
                      .forEach(chef -> {
                          if (chef.getEmail()
                                  .equals(email)) {
                              throw new ChefAlreadyExistsException();
                          }
                      });
    }

    @Override
    public long count() {
        return chefRepository.count();
    }

    @Override
    public Chef getById(long id) throws ChefNotFoundException {
        return chefRepository.findById(id)
                             .orElseThrow(ChefNotFoundException::new);
    }

    public static class ChefNotFoundException extends RuntimeException {

    }
    public static class ChefAlreadyExistsException extends RuntimeException {
    }
}

