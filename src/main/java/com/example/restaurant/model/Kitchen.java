package com.example.restaurant.model;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(Set<Chef> chefs) {
        this.chefs = chefs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
