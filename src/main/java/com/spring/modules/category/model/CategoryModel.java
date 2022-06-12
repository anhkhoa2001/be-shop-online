package com.spring.modules.category.model;

import com.spring.contants.model.AItemModel;
import com.spring.modules.product.models.ProductModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="category")
public class CategoryModel extends AItemModel {

    @OneToMany(fetch = FetchType.EAGER, mappedBy= "categoryModel")
    private Set<ProductModel> productModels;

    @Basic
    private String line;

    @Basic
    private String logo;

    @ManyToOne
    @JoinColumn(name="cmID", nullable=false)
    private ProductLineModel productLineModel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manuID", referencedColumnName = "id")
    private ManufacturerModel manufacturerModel;

    public Set<ProductModel> getProducts() {
        return productModels;
    }

    public void setProducts(final Set<ProductModel> productModels) {
        this.productModels = productModels;
    }

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
        return productLineModel;
    }

    public void setProductLine(final ProductLineModel productLineModel) {
        this.productLineModel = productLineModel;
    }
}
