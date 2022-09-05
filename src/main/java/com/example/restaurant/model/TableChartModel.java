package com.example.restaurant.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@Entity
public class TableChartModel {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String image;

    public TableChartModel(String image) {

        this.image = image;
    }

    public TableChartModel() {

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableChartModel that = (TableChartModel) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public String toString() {
        return "TableChart{" + "tabbleChartId=" + id + ", image='" + image + '\'' + '}';
    }
}
