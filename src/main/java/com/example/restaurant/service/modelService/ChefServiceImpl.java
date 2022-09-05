package com.example.restaurant.service.modelService;

import com.example.restaurant.model.AccountModel;
import com.example.restaurant.model.ChefModel;
import com.example.restaurant.repository.ChefRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ChefServiceImpl implements ChefService {
    private final ChefRepository chefRepository;

    public ChefServiceImpl(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }

    @Override
    public ChefModel create(Date dateJoined, AccountModel accountModel, String name, String phoneNumber, String email) throws ChefAlreadyExistsException {
        checkIfChefExists(email);
        return chefRepository.save(new ChefModel(dateJoined, accountModel, name, phoneNumber, email));
    }
    private void checkIfChefExists(String email) {
        chefRepository.findAll().forEach(chef -> {
            if (chef.getEmail().equals(email)) {
                throw new ChefAlreadyExistsException();
            }
        });
    }

    @Override
    public long count() {
        return chefRepository.count();
    }

    @Override
    public ChefModel getById(long id) throws ChefNotFoundException {
        return chefRepository.findById(id).orElseThrow(ChefNotFoundException::new);
    }

    public static class ChefNotFoundException extends RuntimeException {

    }
    public static class ChefAlreadyExistsException extends RuntimeException {
    }
}

