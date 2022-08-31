package com.example.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "adress", referencedColumnName = "id")
    private Adress location;

    @ManyToOne
    @JoinColumn(name = "kitchen", referencedColumnName = "id")
    private Kitchen kitchen;
    //    private HashMap<Integer, TableChart> tableCharts = new HashMap();
    @OneToMany
    @JoinColumn(name = "employee", referencedColumnName = "id")
    private Set<Employee> employees=new HashSet<>();

    public Branch() {

    }

    public Branch(String name, Adress location, Kitchen kitchen, Set<Employee> employees) {
        this.name = name;
        this.location = location;
        this.kitchen = kitchen;
        this.employees = employees;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Adress getLocation() {
        return location;
    }

    public void setLocation(Adress location) {
        this.location = location;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        return Objects.equals(id, branch.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


//    @Override
//    public String toString() {
//        return "Branch{" + "name='" + name + '\'' + ", location=" + location + ", kitchen=" + kitchen + ", tableCharts=" + tableCharts + ", menu=" + menu + '}';
//    }


}
