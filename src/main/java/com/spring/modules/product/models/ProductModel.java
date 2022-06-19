package com.spring.modules.product.models;
import com.spring.core.model.AItemModel;
import com.spring.modules.category.model.CategoryModel;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Inheritance(strategy=InheritanceType.JOINED)
public class ProductModel extends AItemModel {

    public static final String MODEL_NAME = "Product";

    @Basic
    private String name;

    @Basic
    private long price;

    @Basic
    private int quantityStock;

    @Basic
    private String image;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="cid", nullable=false)
    private CategoryModel category;

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
        return category;
    }

    public void setCategory(final CategoryModel category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantityStock=" + quantityStock +
                ", image='" + image + '\'' +
                ", category=" + category +
                '}';
    }
}