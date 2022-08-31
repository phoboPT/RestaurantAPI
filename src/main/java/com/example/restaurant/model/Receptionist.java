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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Receptionist extends Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    public Receptionist(Date dateJoined, Account account, String name, String phoneNumber, String email) {
        super(dateJoined, account, name, phoneNumber, email);
    }

    public Receptionist() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receptionist that = (Receptionist) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String toString() {
        return (super.toString());
    }

}
