package com.example.restaurant.service;

import com.example.restaurant.service.modelService.AccountService;
import com.example.restaurant.service.modelService.ChefService;
import com.example.restaurant.service.modelService.ChefServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

@SpringBootTest
public class ChefServiceImplTest {
    @Autowired
    private ChefService chefService;

    @Autowired
    private AccountService accountService;

    @Test
    public void createChefShouldSaveChef() {
        var count = chefService.count();
        var account = accountService.create("password",
                                            "Maria",
                                            "street",
                                            "city",
                                            "state",
                                            "zip");
        var chef = chefService.create(new Date(),
                                      account,
                                      "Jorge",
                                      "1234",
                                      "maria@maria.pt");
        assertThat(chefService.count()).isGreaterThan(count);
        assertEquals(chef.getName(),
                     "Jorge");
        assertEquals(chef.getEmail(),
                     "maria@maria.pt");
        assertEquals(chef.getPhone(),
                     "1234");
        assertEquals(chef.getAccountModel()
                         .getPassword(),
                     "password");
        assertEquals(chef.getAccountModel()
                         .getUsername(),
                     "Maria");

        assertEquals(chef.getAccountModel()
                         .getAddressModel()
                         .getStreet(),
                     "street");
        assertEquals(chef.getAccountModel()
                         .getAddressModel()
                         .getCity(),
                     "city");
        assertEquals(chef.getAccountModel()
                         .getAddressModel()
                         .getState(),
                     "state");
        assertEquals(chef.getAccountModel()
                         .getAddressModel()
                         .getZip(),
                     "zip");
        
    }

    @Test
    public void createChefShouldThrowChefAlreadyExistsException() {
        var account = accountService.create("password",
                                            "Antonia",
                                            "street",
                                            "city",
                                            "state",
                                            "zip");
        chefService.create(new Date(),
                           account,
                           "Jorge",
                           "1234",
                           "email");
        assertThrows(ChefServiceImpl.ChefAlreadyExistsException.class,
                     () -> chefService.create(new Date(),
                                              account,
                                              "Maria",
                                              "1234",
                                              "email"));
    }

    @Test
    public void createChefShouldReturnChef() {
        var account = accountService.create("username",
                                            "Joaquim",
                                            "password",
                                            "firstName",
                                            "lastName",
                                            "email");
        var receptionist = chefService.create(new Date(),
                                              account,
                                              "Jorge",
                                              "1234",
                                              "Joaquim@Joaquim.pt");
        assertEquals(receptionist,
                     chefService.getById(receptionist.getId()));
    }

    @Test
    public void createChefShouldReturnChefCount() {

        assertThat(chefService.count()).isGreaterThan(0);
    }

    @Test
    public void createChefShouldThrowChefNotFoundException() throws ChefServiceImpl.ChefNotFoundException {
        assertThrows(ChefServiceImpl.ChefNotFoundException.class,
                     () -> chefService.getById(23123));
    }

}
