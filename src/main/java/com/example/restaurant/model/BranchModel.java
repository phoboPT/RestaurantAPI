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
public class BranchModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn (name = "adress", referencedColumnName = "id")
    private AddressModel location;

    @ManyToOne
    @JoinColumn (name = "kitchen", referencedColumnName = "id")
    private KitchenModel kitchenModel;
    //    private HashMap<Integer, TableChart> tableCharts = new HashMap();
    @OneToMany
    @JoinColumn (name = "employee", referencedColumnName = "id")
    private Collection<EmployeeModel> employeeModels = new ArrayList<>();

    public BranchModel() {

    }

    public BranchModel(String name,
                       AddressModel location,
                       KitchenModel kitchenModel,
                       Collection<EmployeeModel> employeeModels) {
        this.name = name;
        this.location = location;
        this.kitchenModel = kitchenModel;
        this.employeeModels = employeeModels;
    }

    public BranchModel(String name) {
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

        BranchModel branchModel = (BranchModel) o;

        return Objects.equals(id,
                              branchModel.id);
    }

//    @Override
//    public String toString() {
//        return "Branch{" + "name='" + name + '\'' + ", location=" + location + ", kitchen=" + kitchen + ", tableCharts=" + tableCharts + ", menu=" + menu + '}';
//    }

}
