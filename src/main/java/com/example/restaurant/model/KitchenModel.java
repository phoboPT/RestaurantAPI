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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
public class KitchenModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn (name = "chef", referencedColumnName = "id")
    private Collection<ChefModel> chefModels = new ArrayList<>();

    public KitchenModel(String name,
                        Collection<ChefModel> chefModels) {
        this.name = name;
        this.chefModels = chefModels;
    }
    public KitchenModel(String name) {
        this.name = name;

    }

    public KitchenModel() {

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

        KitchenModel kitchenModel = (KitchenModel) o;

        return Objects.equals(id,
                              kitchenModel.id);
    }

    @Override
    public String toString() {

        return "Kitchen{" + "name='" + name + '\'' + ", chefs=" + chefModels + "}";
    }
}
