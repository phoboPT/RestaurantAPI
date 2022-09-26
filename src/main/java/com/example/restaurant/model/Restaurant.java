package com.example.restaurant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Restaurant {
    @Id @GeneratedValue (strategy = GenerationType.AUTO) private Long id;
    private String name;
    @OneToMany @JoinColumn (name = "branch", referencedColumnName = "id")
    private Collection<Branch> branches = new ArrayList<>();

    public Restaurant() {

    }

    public Restaurant(String name) {
        this.name = name;

    }

    public Restaurant(String name, Collection<Branch> branches) {
        this.name = name;
        this.branches = branches;
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

        Restaurant that = (Restaurant) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public String toString() {
        return "Restaurant{" + "name='" + name + '\'' + ", branches=" + branches.toString() + '}';
    }

}
