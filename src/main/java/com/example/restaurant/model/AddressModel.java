package com.example.restaurant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
public class AddressModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zip;

    public AddressModel(String street,
                        String city,
                        String state,
                        String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public AddressModel() {
    }
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AddressModel addressModel = (AddressModel) o;

        return Objects.equals(id,
                              addressModel.id);
    }
    @Override
    public String toString() {
        return "{" + "id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "}";
    }
}
