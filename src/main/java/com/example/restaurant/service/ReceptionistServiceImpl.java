package com.example.restaurant.service;

import com.example.restaurant.model.Account;
import com.example.restaurant.model.Receptionist;
import com.example.restaurant.repository.ReceptionistRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ReceptionistServiceImpl implements ReceptionistService {
    private final ReceptionistRepository receptionistRepository;
    private final AccountService accountService;
    public ReceptionistServiceImpl(ReceptionistRepository receptionistRepository, AccountService accountService) {
        this.receptionistRepository = receptionistRepository;
        this.accountService = accountService;
    }

    @Override
    public Receptionist create(Date dateJoined, Account account, String name, String phoneNumber, String email) {
        var userAccount = accountService.create(account);
        return receptionistRepository.save(new Receptionist(dateJoined, userAccount, name, phoneNumber, email));
    }

    @Override
    public long count() {
        return receptionistRepository.count();

    }

    @Override
    public Receptionist getById(long id) throws ReceptionistNotFoundException {
        return receptionistRepository.findById(id)
                                     .orElseThrow(ReceptionistNotFoundException::new);
    }

    public static class ReceptionistNotFoundException extends RuntimeException {

    }
}
