package com.spring.modules.category.model;

import com.spring.contants.model.AItemModel;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manu")
public class ManufacturerModel extends AItemModel {

    @Basic
    private String name;

    @OneToOne(mappedBy = "manufacturerModel")
    private CategoryModel categoryModel;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(final CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }
}
