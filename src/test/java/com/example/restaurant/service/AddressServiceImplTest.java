package com.example.restaurant.service;

import com.example.restaurant.service.modelService.AddressService;
import com.example.restaurant.service.modelService.AddressServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AddressServiceImplTest {
    @Autowired
    private AddressService addressService;

    @Test
    public void createAddressShouldSaveAddress() {
        var count = addressService.count();
        var address = addressService.create("street",
                                            "city",
                                            "state",
                                            "zip");
        assertThat(addressService.count()).isGreaterThan(count);
        assertEquals(address.getStreet(),
                     "street");
        assertEquals(address.getCity(),
                     "city");
        assertEquals(address.getState(),
                     "state");
        assertEquals(address.getZip(),
                     "zip");
    }

    @Test
    public void createAddressShouldReturnAddress() {
        var address = addressService.create("street",
                                            "city",
                                            "state",
                                            "zip");
        assertThat(address).isNotNull();
    }

    @Test
    public void shouldReturnAnAddressGivenTheId() {
        var address = addressService.create("street",
                                            "city",
                                            "state",
                                            "zip");

        assertEquals(address,
                     addressService.getById(address.getId()));
    }

    @Test
    public void shouldThrowAddressNotFoundExceptionGivenAnInvalidId() {
        assertThrows(AddressServiceImpl.AddressNotFoundException.class,
                     () -> addressService.getById(23123));
    }

}
