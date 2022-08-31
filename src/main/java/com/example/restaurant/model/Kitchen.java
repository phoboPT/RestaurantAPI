package com.example.restaurant.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Kitchen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "chef", referencedColumnName = "id")
    private Set<Chef> chefs = new HashSet<>();

    public Kitchen(String name, Set<Chef> chefs) {
        this.name = name;
        this.chefs = chefs;
    }

    public Kitchen() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kitchen kitchen = (Kitchen) o;

        return Objects.equals(id, kitchen.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {

        return "Kitchen{" + "name='" + name + '\'' + ", chefs=" + chefs + "}";
    }
}
