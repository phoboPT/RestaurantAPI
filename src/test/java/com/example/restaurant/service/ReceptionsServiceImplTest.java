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
public class ReceptionsServiceImplTest {
    @Autowired private ReceptionistService receptionistService;

    @Autowired private AccountService accountService;

    @Test
    public void createReceptionShouldSaveReceptionist() {
        var count = receptionistService.count();
        String username = "manuel";
        var account = AccountDataBuilder.buildFullAccountWithUsername(username);
        String name = "Eduardo";
        String phoneNumber = "1234";
        String email = "email";
        var receptionist = receptionistService.create(new Date(), account, name, phoneNumber, email);
        assertThat(receptionistService.count()).isGreaterThan(count);
        assertEquals(receptionist.getName(), name);
        assertEquals(receptionist.getEmail(), email);
        assertEquals(receptionist.getPhone(), phoneNumber);
        assertEquals(receptionist.getAccount()
                                 .getPassword(), "password");
        assertEquals(receptionist.getAccount()
                                 .getUsername(), username);
        assertEquals(receptionist.getAccount()
                                 .getAddress()
                                 .getStreet(), "street");
        assertEquals(receptionist.getAccount()
                                 .getAddress()
                                 .getCity(), "city");
        assertEquals(receptionist.getAccount()
                                 .getAddress()
                                 .getState(), "state");
        assertEquals(receptionist.getAccount()
                                 .getAddress()
                                 .getZip(), "zip");
    }

    @Test
    public void createReceptionShouldReturnReceptionist() {
        var account = AccountDataBuilder.buildFullAccountWithUsername("username2");
        var receptionist = receptionistService.create(new Date(), account, "Jorge", "1234", "email");
        assertEquals(receptionist, receptionistService.getById(receptionist.getId()));
    }

    @Test
    public void createReceptionShouldReturnReceptionistCount() {
        assertThat(receptionistService.count()).isGreaterThan(0);
    }

    @Test
    public void createReceptionShouldThrowReceptionNotFoundException() throws
                                                                       ReceptionistServiceImpl.ReceptionistNotFoundException {
        assertThrows(ReceptionistServiceImpl.ReceptionistNotFoundException.class,
                     () -> receptionistService.getById(23123));
    }

    @Test
    public void findByIdShouldReturnReceptionist() {
        var account = AccountDataBuilder.buildFullAccountWithUsername("username3");
        var receptionist = receptionistService.create(new Date(), account, "Jorge", "1234", "email");
        assertEquals(receptionist, receptionistService.getById(receptionist.getId()));
    }

}
