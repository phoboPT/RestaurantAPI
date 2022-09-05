package com.example.restaurant.service.modelService;

import com.example.restaurant.model.AccountModel;
import com.example.restaurant.model.ManagerModel;
import com.example.restaurant.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public ManagerModel create(String name,
                               AccountModel account,
                               String email,
                               String phone) {
        return managerRepository.save(new ManagerModel(new Date(),
                                                       account,
                                                       name,
                                                       phone,
                                                       email));
    }

    @Override
    public long count() {
        return managerRepository.count();
    }

    @Override
    public ManagerModel getById(long id) throws ManagerNotFoundException {
        return managerRepository.findById(id)
                                .orElseThrow(ManagerNotFoundException::new);
    }

    public static class ManagerNotFoundException extends RuntimeException {

    }
}
