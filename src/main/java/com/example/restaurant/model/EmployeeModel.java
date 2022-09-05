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
public abstract class EmployeeModel extends PersonModel {
    @Id
    @GeneratedValue (strategy = GenerationType.TABLE)
    private Long id;
    private Date dateJoined;
    @ManyToOne
    @JoinColumn (name = "account", referencedColumnName = "id")
    private AccountModel accountModel;

    public EmployeeModel(Date dateJoined,
                         AccountModel accountModel,
                         String name,
                         String phoneNumber,
                         String email) {
        super(name,
              email,
              phoneNumber);
        this.dateJoined = dateJoined;
        this.accountModel = accountModel;
    }

    public EmployeeModel() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + " \n" + "Employee{" + ", dateJoined=" + dateJoined + ", account=" + accountModel + '}';
    }
}
