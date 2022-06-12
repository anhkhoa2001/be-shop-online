package com.spring.modules.category.model;

import com.spring.contants.model.AItemModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="productline")
public class ProductLineModel extends AItemModel {

    @Basic
    private String icon;

    @Basic
    private String image;

    @Basic
    private String line;

    @Basic
    private String slogan;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy= "productLineModel")
    private Set<CategoryModel> categories;

    public String getIcon() {
        return icon;
    }

    public void setIcon(final String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getLine() {
        return line;
    }

    public void setLine(final String line) {
        this.line = line;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(final String slogan) {
        this.slogan = slogan;
    }

    public Set<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(final Set<CategoryModel> categories) {
        this.categories = categories;
    }
}
