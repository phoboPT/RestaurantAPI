package com.example.restaurant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public class Employee extends Person {
    @Id @GeneratedValue (strategy = GenerationType.TABLE) private Long id;
    private Date dateJoined;
    @ManyToOne @JoinColumn (name = "account", referencedColumnName = "id") private Account account;

    public Employee(Date dateJoined, Account account, String name, String phoneNumber, String email) {
        super(name, email, phoneNumber);
        this.dateJoined = dateJoined;
        this.account = account;
    }

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + " \n" + "Employee{" + ", dateJoined=" + dateJoined + ", account=" + account + '}';
    }
}
