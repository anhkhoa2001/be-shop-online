package com.spring.modules.checkout.models;

import com.spring.core.model.AItemModel;
import com.spring.modules.category.model.CategoryModel;
import com.spring.modules.checkout.controllers.dtos.OrderDTO;

import javax.persistence.*;

@Entity
@Table(name = "orderproduct")
public class OrderProductModel extends AItemModel {

    public static final String MODEL_NAME = "OrderProduct";

    @Basic
    private int quantity;

    @Basic
    private int total;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name="oid", nullable=false)
    private OrderModel orderModel;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name="cid")
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

    public OrderProductModel(String code, int quantity, int total) {
        super();
        super.setCode(code);
        this.quantity = quantity;
        this.total = total;
    }

    public OrderProductModel() {}
}
