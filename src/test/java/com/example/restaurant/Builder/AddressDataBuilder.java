package com.example.restaurant.Builder;

import com.example.restaurant.model.Address;
public class AddressDataBuilder {

    public static Address buildAddress() {
        return new Address("street", "city", "state", "zip");
    }
}
