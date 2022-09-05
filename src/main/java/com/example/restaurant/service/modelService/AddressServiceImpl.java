package com.example.restaurant.service.modelService;

import com.example.restaurant.model.AddressModel;
import com.example.restaurant.repository.AdressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AdressRepository adressRepository;

    public AddressServiceImpl(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public AddressModel create(String street, String city, String state, String zip) {
        AddressModel addressModel = new AddressModel(street, city, state, zip);
        adressRepository.save(addressModel);
        return addressModel;
    }

    @Override
    public long count() {
        return adressRepository.count();
    }

    @Override
    public AddressModel getById(long id) throws AddressNotFoundException {
        return adressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
    }

    public static class AddressNotFoundException extends RuntimeException {

    }
}
