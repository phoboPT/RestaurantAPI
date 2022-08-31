package com.example.restaurant.configuration;

import com.example.restaurant.enums.AccountStatus;
import com.example.restaurant.model.Adress;
import com.example.restaurant.repositories.AccountRepository;
import com.example.restaurant.repositories.AdressRepository;
import com.example.restaurant.services.AccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {


    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AccountRepository accountRepository, AdressRepository adressRepository) {

        return args -> {
//            AccountServiceImpl accountImpl = new AccountServiceImpl(accountRepository);
//            Adress adress = new Adress("Krakowska", "1", "Warszawa", "Polska");
//            adressRepository.save(adress);
//            accountImpl.createAccount("password", adress, AccountStatus.ACTIVE);
//        Chef chef = new Chef(new Date(), account, "Kowalski", "23123", "teste");
//        chefRepository.save(chef);
//        Set<Chef> chefs = new HashSet<>();
//        chefs.add(chef);
//        Set<Employee> employees = new HashSet<>();
//        Kitchen kitchen = new Kitchen("Kuchnia", chefs);
//        kitchenRepository.save(kitchen);
//        Branch branch = new Branch("Warszawa", adress, kitchen, employees);
//        branchRepository.save(branch);
            log.info("Preloading " + accountRepository.count() + " accounts");

        };
    }

}
