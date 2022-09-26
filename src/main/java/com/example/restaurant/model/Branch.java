package com.example.restaurant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Branch {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)

    private Long id;

    private String name;
    @ManyToOne @JoinColumn (name = "address", referencedColumnName = "id") private Address location;

    @ManyToOne @JoinColumn (name = "kitchen", referencedColumnName = "id") private Kitchen kitchen;
    //    private HashMap<Integer, TableChart> tableCharts = new HashMap();
    @OneToMany @JoinColumn (name = "employee", referencedColumnName = "id")
    private Collection<Employee> employees = new ArrayList<>();

    public Branch() {

    }

    public Branch(String name, Address location, Kitchen kitchen, Collection<Employee> employees) {
        this.name = name;
        this.location = location;
        this.kitchen = kitchen;
        this.employees = employees;
    }

    public Branch(String name) {
        this.name = name;

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

        Branch branch = (Branch) o;

        return Objects.equals(id, branch.id);
    }

//    @Override
//    public String toString() {
//        return "Branch{" + "name='" + name + '\'' + ", location=" + location + ", kitchen=" + kitchen + ", tableCharts=" + tableCharts + ", menu=" + menu + '}';
//    }

}
