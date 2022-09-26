package com.example.restaurant.service;

import com.example.restaurant.Builder.AccountDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

@SpringBootTest
public class ChefServiceImplTest {
    @Autowired private ChefService chefService;

    @Autowired private AccountService accountService;

    @Test
    public void createChefShouldSaveChef() {
        var count = chefService.count();
        String name = "Gonçalo";
        var account = AccountDataBuilder.buildFullAccountWithUsername(name);
        String phoneNumber = "1234";
        String email = "maria@maria.pt";
        var chef = chefService.create(new Date(), account, name, phoneNumber, email);
        assertThat(chefService.count()).isGreaterThan(count);
        assertEquals(chef.getName(), name);
        assertEquals(chef.getEmail(), email);
        assertEquals(chef.getPhone(), phoneNumber);
        assertEquals(chef.getAccount()
                         .getPassword(), "password");
        assertEquals(chef.getAccount()
                         .getUsername(), name);

        assertEquals(chef.getAccount()
                         .getAddress()
                         .getStreet(), "street");
        assertEquals(chef.getAccount()
                         .getAddress()
                         .getCity(), "city");
        assertEquals(chef.getAccount()
                         .getAddress()
                         .getState(), "state");
        assertEquals(chef.getAccount()
                         .getAddress()
                         .getZip(), "zip");

    }

    @Test
    public void createChefShouldThrowChefAlreadyExistsException() {
        String name = "Antonia";
        var account = AccountDataBuilder.buildFullAccountWithUsername(name);
        String phoneNumber = "1234";
        String email = "email";
        chefService.create(new Date(), account, name, phoneNumber, email);
        assertThrows(ChefServiceImpl.ChefAlreadyExistsException.class,
                     () -> chefService.create(new Date(), account, name, phoneNumber, email));
    }

    @Test
    public void createChefShouldReturnChef() {
        String name = "Ricardo";
        var account = AccountDataBuilder.buildFullAccountWithUsername(name);
        var receptionist = chefService.create(new Date(), account, name, "1234", "Joaquim@Joaquim.pt");
        assertEquals(receptionist, chefService.getById(receptionist.getId()));
    }

    @Test
    public void createChefShouldReturnChefCount() {

        assertThat(chefService.count()).isGreaterThan(0);
    }

    @Test
    public void createChefShouldThrowChefNotFoundException() throws ChefServiceImpl.ChefNotFoundException {
        assertThrows(ChefServiceImpl.ChefNotFoundException.class, () -> chefService.getById(23123));
    }

}
