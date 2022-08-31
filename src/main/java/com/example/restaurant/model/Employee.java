package com.example.restaurant.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public Employee(String name, String email, String phone, Date dateJoined, Account account) {
        super(name, email, phone);
        this.dateJoined = dateJoined;
        this.account = account;
    }

    private Date dateJoined;
    @ManyToOne
    @JoinColumn(name = "account", referencedColumnName = "id")
    private Account account;

    public Employee(Date dateJoined, Account account, String name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
        this.dateJoined = dateJoined;
        this.account = account;
    }

    public Employee() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return super.getName();
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return super.toString() + " \n" +
                "Employee{" +
                ", dateJoined=" + dateJoined +
                ", account=" + account + '}';
    }
}
