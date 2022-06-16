package com.spring.modules.category.model;

import com.spring.core.model.AItemModel;

import javax.persistence.*;

@Entity
@Table(name = "manu")
public class ManufacturerModel extends AItemModel {

    public static final String MODEL_NAME = "Manufacturer";

    @Column(unique = true, name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ManufacturerModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
