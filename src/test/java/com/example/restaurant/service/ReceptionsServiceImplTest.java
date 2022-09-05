package com.example.restaurant.service;

import com.example.restaurant.service.modelService.AccountService;
import com.example.restaurant.service.modelService.ReceptionistService;
import com.example.restaurant.service.modelService.ReceptionistServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

@SpringBootTest
public class ReceptionsServiceImplTest {
    @Autowired
    private ReceptionistService receptionistService;

    @Autowired
    private AccountService accountService;

    @Test
    public void createReceptionShouldSaveReceptionist() {
        var count = receptionistService.count();
        var account = accountService.create("password",
                                            "manuel",
                                            "street",
                                            "city",
                                            "state",
                                            "zip");
        var receptionist = receptionistService.create(new Date(),
                                                      account,
                                                      "Eduardo",
                                                      "1234",
                                                      "email");
        assertThat(receptionistService.count()).isGreaterThan(count);
        assertEquals(receptionist.getName(),
                     "Eduardo");
        assertEquals(receptionist.getEmail(),
                     "email");
        assertEquals(receptionist.getPhone(),
                     "1234");
        assertEquals(receptionist.getAccountModel()
                                 .getPassword(),
                     "password");
        assertEquals(receptionist.getAccountModel()
                                 .getUsername(),
                     "manuel");
        assertEquals(receptionist.getAccountModel()
                                 .getAddressModel()
                                 .getStreet(),
                     "street");
        assertEquals(receptionist.getAccountModel()
                                 .getAddressModel()
                                 .getCity(),
                     "city");
        assertEquals(receptionist.getAccountModel()
                                 .getAddressModel()
                                 .getState(),
                     "state");
        assertEquals(receptionist.getAccountModel()
                                 .getAddressModel()
                                 .getZip(),
                     "zip");
    }

    @Test
    public void createReceptionShouldReturnReceptionist() {
        var account = accountService.create("password",
                                            "antonio",
                                            "street",
                                            "city",
                                            "state",
                                            "zip");
        var receptionist = receptionistService.create(new Date(),
                                                      account,
                                                      "Jorge",
                                                      "1234",
                                                      "email");
        assertEquals(receptionist,
                     receptionistService.getById(receptionist.getId()));
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

}
