package com.example.restaurant.service;

import com.example.restaurant.model.Address;
import com.example.restaurant.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(String street,
                          String city,
                          String state,
                          String zip) {
        Address address = new Address(street,
                                      city,
                                      state,
                                      zip);
        addressRepository.save(address);
        return address;
    }

    @Override
    public long count() {
        return addressRepository.count();
    }

    @Override
    public Address getById(long id) throws AddressNotFoundException {
        return addressRepository.findById(id)
                                .orElseThrow(AddressNotFoundException::new);
    }

    public static class AddressNotFoundException extends RuntimeException {

    }
}
