package com.example.restaurant.service;

import com.example.restaurant.service.modelService.AccountService;
import com.example.restaurant.service.modelService.ManagerService;
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
        assertEquals(manager.getAccountModel()
                            .getUsername(),
                     "Filipe");
        assertEquals(manager.getAccountModel()
                            .getPassword(),
                     "password");
        assertEquals(manager.getAccountModel()
                            .getAddressModel()
                            .getStreet(),
                     "street");
        assertEquals(manager.getAccountModel()
                            .getAddressModel()
                            .getCity(),
                     "city");
        assertEquals(manager.getAccountModel()
                            .getAddressModel()
                            .getState(),
                     "state");
        assertEquals(manager.getAccountModel()
                            .getAddressModel()
                            .getZip(),
                     "zip");

    }
}
