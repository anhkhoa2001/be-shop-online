package com.spring.modules.category.model;

import com.spring.core.model.AItemModel;
import com.spring.modules.product.models.ProductModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="category")
public class CategoryModel extends AItemModel {

    public static final String MODEL_NAME = "Category";

    @OneToMany(mappedBy="category")
    private Set<ProductModel> products;

    @Basic
    private String line;

    @Basic
    private String logo;

    @Basic
    private String categoryCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cmID", nullable=false)
    private ProductLineModel productLine;

    @OneToOne
    @JoinColumn(name = "manuID", referencedColumnName = "id")
    private ManufacturerModel manufacturer;

    public String getLine() {
        return line;
    }

    public void setLine(final String line) {
        this.line = line;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(final String logo) {
        this.logo = logo;
    }

    public ProductLineModel getProductLine() {
        return productLine;
    }

    public void setProductLine(final ProductLineModel productLine) {
        this.productLine = productLine;
    }

    public ManufacturerModel getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(final ManufacturerModel manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(final Set<ProductModel> products) {
        this.products = products;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(final String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
