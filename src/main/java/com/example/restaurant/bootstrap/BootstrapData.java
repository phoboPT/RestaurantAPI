package com.example.restaurant.bootstrap;

import com.example.restaurant.enums.AccountStatus;
import com.example.restaurant.model.Account;
import com.example.restaurant.model.Adress;
import com.example.restaurant.model.Branch;
import com.example.restaurant.model.Chef;
import com.example.restaurant.model.Employee;
import com.example.restaurant.model.Kitchen;
import com.example.restaurant.repositories.AccountRepository;
import com.example.restaurant.repositories.AdressRepository;
import com.example.restaurant.repositories.BranchRepository;
import com.example.restaurant.repositories.ChefRepository;
import com.example.restaurant.repositories.CustomerRepository;
import com.example.restaurant.repositories.KitchenRepository;
import com.example.restaurant.repositories.ManagerRepository;
import com.example.restaurant.repositories.ReceptionistRepository;
import com.example.restaurant.repositories.RestaurantRepository;
import com.example.restaurant.repositories.WaiterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final AdressRepository adressRepository;
    private final BranchRepository branchRepository;
    private final ChefRepository chefRepository;
    private final CustomerRepository customerRepository;
    private final KitchenRepository kitchenRepository;
    private final ManagerRepository managerRepository;
    private final ReceptionistRepository receptionistRepository;
    private final RestaurantRepository restaurantRepository;
    private final WaiterRepository waiterRepository;

    public BootstrapData(AccountRepository accountRepository,
                         AdressRepository adressRepository,
                         BranchRepository branchRepository,
                         CustomerRepository customerRepository,
                         ManagerRepository managerRepository,
                         ReceptionistRepository receptionistRepository,
                         WaiterRepository waiterRepository,
                         ChefRepository chefRepository, KitchenRepository kitchenRepository, RestaurantRepository restaurantRepository) {
        this.accountRepository = accountRepository;
        this.adressRepository = adressRepository;
        this.branchRepository = branchRepository;
        this.chefRepository = chefRepository;
        this.customerRepository = customerRepository;
        this.managerRepository = managerRepository;
        this.receptionistRepository = receptionistRepository;
        this.waiterRepository = waiterRepository;
        this.kitchenRepository = kitchenRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        Adress adress = new Adress("Krakowska", "1", "Warszawa", "Polska");
//        adressRepository.save(adress);
//        Account account = new Account("admin", adress, AccountStatus.ACTIVE);
//        accountRepository.save(account);
//        Chef chef = new Chef(new Date(), account, "Kowalski", "23123", "teste");
//        chefRepository.save(chef);
//        Set<Chef> chefs = new HashSet<>();
//        chefs.add(chef);
//        Set<Employee> employees = new HashSet<>();
//        Kitchen kitchen = new Kitchen("Kuchnia", chefs);
//        kitchenRepository.save(kitchen);
//        Branch branch = new Branch("Warszawa", adress, kitchen, employees);
//        branchRepository.save(branch);
//        System.out.println(kitchenRepository.findAll());
        System.out.println("Started in BootstrapData");
//        System.out.println("Accounts: " + accountRepository.count());
    }
}
