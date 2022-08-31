package com.example.restaurant.service;

import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeMethod;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AddressServiceImplTest {
    @Autowired
    private AddressService addressService;


    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createAdressShouldSaveAdress() {
        var adress=addressService.createAddress("street", "city", "state", "zip");
        assertThat(adress).isNotNull();
    }

    @Test
    public void createAdressShouldReturnAdress() {
        var adress=addressService.createAddress("street", "city", "state", "zip");
        assertThat(adress).isNotNull();
        assertEquals(addressService.getAddress(adress.getId()), adress);
    }

}
