package com.example.restaurant.services;

import com.example.restaurant.model.Adress;
import com.example.restaurant.repositories.AdressRepository;
import org.springframework.stereotype.Service;

@Service
public class AdressServiceImpl implements AdressService {
    private AdressRepository adressRepository;

    public AdressServiceImpl(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public Adress createAdress(String street, String city, String state, String zip) {
        Adress adress = new Adress(street, city, state, zip);
        adressRepository.save(adress);
        return adress;
    }

    @Override
    public long count() {
        return adressRepository.count();
    }


}
