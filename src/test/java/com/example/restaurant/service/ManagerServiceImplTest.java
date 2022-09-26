package com.example.restaurant.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
@SpringBootTest
public class ManagerServiceImplTest {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private AccountService accountService;
    @Test
    public void createManagerShouldSaveManager() {
        var count = managerService.count();
        var account = accountService.create("password",
                                            "Filipe",
                                            "street",
                                            "city",
                                            "state",
                                            "zip");
        var manager = managerService.create("manuel",
                                            account,
                                            "email",
                                            "123123");
        assertThat(managerService.count()).isGreaterThan(count);
        assertEquals(manager.getName(),
                     "manuel");
        assertEquals(manager.getEmail(),
                     "email");
        assertEquals(manager.getPhone(),
                     "123123");
        assertEquals(manager.getAccount()
                            .getUsername(),
                     "Filipe");
        assertEquals(manager.getAccount()
                            .getPassword(),
                     "password");
        assertEquals(manager.getAccount()
                            .getAddress()
                            .getStreet(),
                     "street");
        assertEquals(manager.getAccount()
                            .getAddress()
                            .getCity(),
                     "city");
        assertEquals(manager.getAccount()
                            .getAddress()
                            .getState(),
                     "state");
        assertEquals(manager.getAccount()
                            .getAddress()
                            .getZip(),
                     "zip");

    }
}
