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
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class ManagerModel extends EmployeeModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    public ManagerModel(Date dateJoined,
                        AccountModel accountModel,
                        String name,
                        String phoneNumber,
                        String email) {
        super(dateJoined,
              accountModel,
              name,
              phoneNumber,
              email);
    }

    public ManagerModel() {
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

        ManagerModel managerModel = (ManagerModel) o;

        return Objects.equals(id,
                              managerModel.id);
    }
    public String toString() {
        return (super.toString());
    }
}
