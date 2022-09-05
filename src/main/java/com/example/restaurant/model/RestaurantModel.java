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
public class RestaurantModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn (name = "branch", referencedColumnName = "id")
    private Collection<BranchModel> branchModels = new ArrayList<>();

    public RestaurantModel() {

    }

    public RestaurantModel(String name) {
        this.name = name;

    }

    public RestaurantModel(String name, Collection<BranchModel> branchModels) {
        this.name = name;
        this.branchModels = branchModels;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantModel that = (RestaurantModel) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public String toString() {
        return "Restaurant{" + "name='" + name + '\'' + ", branches=" + branchModels.toString() + '}';
    }

}
