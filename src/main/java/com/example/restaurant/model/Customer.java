package com.example.restaurant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Customer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date lastVisited;

    public Customer(Date lastVisited, String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
        this.lastVisited = lastVisited;
    }

    public Customer() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String toString() {
        return (super.toString() + "\nLast visited: " + lastVisited);
    }
}

