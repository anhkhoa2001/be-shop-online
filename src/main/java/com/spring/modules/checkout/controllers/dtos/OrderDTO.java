package com.spring.modules.checkout.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.core.controller.dto.AItemDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Schema(title = OrderDTO.DTO_NAME, description = "Data transfer object for " + OrderDTO.DTO_NAME)
public class OrderDTO extends AItemDTO {

    public static final String DTO_NAME = "OrderDTO";

    @Schema(example = DTO_NAME)
    private String type;

    @Schema(example = "DAM KHOA")
    private String name;

    @Schema(example = "khoadamtam@gmail.com")
    private String email;

    @Schema(example = "0981882815")
    private String phone;

    @Schema(example = "Vinh Thuong Phu Xuyen Ha Noi")
    private String address;

    @Schema(example = "2")
    private int quantity;

    @Schema(example = "27-03-2022")
    private String created;

    @Schema(example = "2818")
    private int total;

    @Schema(example = "1")
    private boolean status;

    @Schema(example = "[....]")
    private List<OrderProductDTO> orderProductDTOs;

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

    public List<OrderProductDTO> getOrderProductDTOs() {
        return orderProductDTOs;
    }

    public void setOrderProductDTOs(final List<OrderProductDTO> orderProductDTOs) {
        this.orderProductDTOs = orderProductDTOs;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public OrderDTO() {
        this.setType(OrderDTO.DTO_NAME);
    }

    public OrderDTO(String name, String email, String phone, String address, int quantity, String created, int total) {
        super();
        this.setType(OrderDTO.DTO_NAME);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.quantity = quantity;
        this.created = created;
        this.total = total;
    }

    public OrderDTO(String name, String email, String phone, String address, int quantity,
                  String created, int total, boolean status) {
        super();
        this.setType(OrderDTO.DTO_NAME);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.quantity = quantity;
        this.created = created;
        this.total = total;
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", quantity=" + quantity +
                ", created='" + created + '\'' +
                ", total=" + total +
                ", status=" + status +
                ", orderProductDTOs=" + orderProductDTOs +
                "} " + super.toString();
    }
}
