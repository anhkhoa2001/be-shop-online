package com.spring.modules.product.models;
import com.spring.core.model.AItemModel;
import com.spring.modules.category.model.CategoryModel;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductModel extends AItemModel {

    @Basic
    private String name;

    @Basic
    private long price;

    @Basic
    private int quantityStock;

    @Basic
    private String image;

    @ManyToOne
    @JoinColumn(name="cid", nullable=false)
    private CategoryModel categoryModel;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(final long price) {
        this.price = price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(final int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public CategoryModel getCategory() {
        return categoryModel;
    }

    public void setCategory(final CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }
}