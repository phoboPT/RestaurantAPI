package com.example.restaurant.service;

import com.example.restaurant.model.Account;
import com.example.restaurant.model.Employee;
import com.example.restaurant.model.Manager;
import com.example.restaurant.repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ManagerServiceImpl implements ManagerService {

    private static final String WAITER = "waiter";
    private static final String CHEF = "chef";
    private static final String RECEPTIONIST = "receptionist";
    private static final String MANAGER = "manager";
    private final ManagerRepository managerRepository;
    private final ChefService chefService;
    private final WaiterService waiterService;
    private final ReceptionistService receptionistService;

    public ManagerServiceImpl(ManagerRepository managerRepository, ChefService chefService, WaiterService waiterService,
                              ReceptionistService receptionistService) {
        this.managerRepository = managerRepository;
        this.chefService = chefService;
        this.waiterService = waiterService;
        this.receptionistService = receptionistService;

    }
    public static class ManagerNotFoundException extends RuntimeException {

    }
    @Override
    public Manager create(String name, Account account, String email, String phone) {

        return managerRepository.save(new Manager(new Date(), account, name, phone, email));
    }

    @Override
    public long count() {
        return managerRepository.count();
    }

    @Override
    public Manager getById(long id) throws ManagerNotFoundException {
        return managerRepository.findById(id)
                                .orElseThrow(ManagerNotFoundException::new);
    }
    @Override
    public Employee addEmployee(String name, Account account, String email, String phone, String type) {
        return switch (type) {
            case CHEF -> chefService.create(new Date(), account, name, phone, email);
            case WAITER -> waiterService.create(new Date(), account, name, phone, email);
            case RECEPTIONIST -> receptionistService.create(new Date(), account, name, phone, email);
            case MANAGER -> create(name, account, email, phone);
            default -> null;
        };
    }

}
