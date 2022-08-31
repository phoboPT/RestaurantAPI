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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "adress", referencedColumnName = "id")
    private Address location;

    @ManyToOne
    @JoinColumn(name = "kitchen", referencedColumnName = "id")
    private Kitchen kitchen;
    //    private HashMap<Integer, TableChart> tableCharts = new HashMap();
    @OneToMany
    @JoinColumn(name = "employee", referencedColumnName = "id")
    private Set<Employee> employees=new HashSet<>();

    public Branch() {

    }

    public Branch(String name, Address location, Kitchen kitchen, Set<Employee> employees) {
        this.name = name;
        this.location = location;
        this.kitchen = kitchen;
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
