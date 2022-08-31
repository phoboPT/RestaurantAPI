package com.example.restaurant.configuration;

import com.example.restaurant.service.AccountService;
import com.example.restaurant.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {


    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    AccountService accountService;
    AddressService addressService;

    public LoadDatabase(AccountService accountService, AddressService addressService) {
        this.accountService = accountService;
        this.addressService = addressService;
    }
    @Bean
    CommandLineRunner initDatabase() {

        return args -> {
//            accountService.createAccount("password", "street", "city", "state", "zip");
//
//            adressService.createAdress("Krakowska", "1", "Warszawa", "Polska");

//        Chef chef = new Chef(new Date(), account, "Kowalski", "23123", "teste");
//        chefRepository.save(chef);
//        Set<Chef> chefs = new HashSet<>();
//        chefs.add(chef);
//        Set<Employee> employees = new HashSet<>();
//        Kitchen kitchen = new Kitchen("Kuchnia", chefs);
//        kitchenRepository.save(kitchen);
//        Branch branch = new Branch("Warszawa", adress, kitchen, employees);
//        branchRepository.save(branch);
            log.info("Preloading " + accountService.count() + " accounts");
            log.info("Preloading " + addressService.count() + " adresses");

        };
    }

}
