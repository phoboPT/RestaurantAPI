package com.example.restaurant.model;

import com.example.restaurant.enums.AccountStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Objects;

@Getter
@Setter
@Entity
public class AccountModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    @OneToOne
    @JoinColumn (name = "address", referencedColumnName = "id")
    @JsonProperty ("address")
    private AddressModel addressModel;
    private AccountStatus status;
    private String username;

    public AccountModel(String password,
                        String username,
                        AddressModel addressModel,
                        AccountStatus status) {
        this.password = password;
        this.username = username;
        this.addressModel = addressModel;
        this.status = status;
    }

    public AccountModel() {
    }

    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AccountModel accountModel = (AccountModel) o;

        return Objects.equals(id,
                              accountModel.id);
    }

    @Override
    public String toString() {
        return "{" + "id='" + id + '\'' + ", password='" + password + '\'' + ", address=" + addressModel + ", status=" + status + "}";
    }
}
