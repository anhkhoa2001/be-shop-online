package com.spring.modules.checkout.models;

import com.spring.core.model.AItemModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrderModel extends AItemModel {

    public static final String MODEL_NAME = "Order";

    @Basic
    private String name;

    @Basic
    private String email;

    @Basic
    private String phone;

    @Basic
    private String address;

    @Basic
    private int quantity;

    @Basic
    private String created;

    @Basic
    private int total;

    @Basic
    private boolean status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="orderModel", cascade = CascadeType.ALL)
    private Set<OrderProductModel> orderProducts;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(final String created) {
        this.created = created;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(final int total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(final boolean status) {
        this.status = status;
    }

    public Set<OrderProductModel> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(final Set<OrderProductModel> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
