package com.example.restaurant.service;

import com.example.restaurant.exception.AddressNotFoundException;
import com.example.restaurant.model.Address;
import com.example.restaurant.repository.AdressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AdressRepository adressRepository;

    public AddressServiceImpl(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public Address createAddress(String street, String city, String state, String zip) {
        Address address = new Address(street, city, state, zip);
        adressRepository.save(address);
        return address;
    }

    @Override
    public long count() {
        return adressRepository.count();
    }

    @Override
    public Address getAddress(long id) throws AddressNotFoundException {
        return adressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("address not found " + id));
    }


}
