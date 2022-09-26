package com.example.restaurant.Builder;

import com.example.restaurant.enums.AccountStatus;
import com.example.restaurant.model.Account;
public class AccountDataBuilder {

    public static Account buildFullAccount() {
        var address = AddressDataBuilder.buildAddress();
        return new Account("password", "username", address, AccountStatus.ACTIVE);
    }
    public static Account buildFullAccountWithUsername(String username) {
        var address = AddressDataBuilder.buildAddress();
        return new Account("password", username, address, AccountStatus.ACTIVE);
    }
}
