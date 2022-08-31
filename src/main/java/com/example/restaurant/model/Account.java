package com.example.restaurant.model;


import com.example.restaurant.enums.AccountStatus;
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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String password;
    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;
    private AccountStatus status;

    public Account(String password, Address address, AccountStatus status) {
        this.password = password;
        this.address = address;
        this.status = status;
    }

    public Account() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "{" + "id='" + id + '\'' + ", password='" + password + '\'' + ", address=" + address + ", status=" + status + '}';
    }
}
