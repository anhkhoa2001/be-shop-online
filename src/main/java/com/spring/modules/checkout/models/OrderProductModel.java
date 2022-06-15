package com.spring.modules.checkout.models;

import com.spring.core.model.AItemModel;
import com.spring.modules.category.model.CategoryModel;

import javax.persistence.*;

@Entity
@Table(name = "orderproduct")
public class OrderProductModel extends AItemModel {

    @Basic
    private int quantity;

    @Basic
    private int total;

    @ManyToOne
    @JoinColumn(name="oid", nullable=false)
    private OrderModel orderModel;

    @ManyToOne
    @JoinColumn(name="cid", nullable=false)
    private CategoryModel categoryModel;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(final int total) {
        this.total = total;
    }

    public OrderModel getOrders() {
        return orderModel;
    }

    public void setOrders(final OrderModel orderModel) {
        this.orderModel = orderModel;
    }

    public CategoryModel getCategory() {
        return categoryModel;
    }

    public void setCategory(final CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }
}
