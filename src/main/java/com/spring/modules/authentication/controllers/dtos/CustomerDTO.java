package com.spring.modules.authentication.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.core.controller.dto.AItemDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Schema(title = CustomerDTO.DTO_NAME, description = "Data transfer object for " + CustomerDTO.DTO_NAME)
public class CustomerDTO extends AItemDTO {

    public static final String DTO_NAME = "CustomerDTO";

    @Schema(example = DTO_NAME)
    private String type;

    @Schema(example = "Khoa Dam Tam", required = true)
    private String name;

    @Schema(example = "admin", required = true)
    private String username;

    @Schema(example = "***", required = true)
    private String password;

    @Schema(example = "Cau Giay - Ha Noi")
    private String address;

    @Schema(example = "CUSTOMER")
    private String role;

    @Schema(example = "...")
    private String createdDay;

    @Schema(example = "khoadamtam@gmail.com")
    private String email;

    @Schema(example = "0981882815")
    private String phone;

    @Schema(example = "1")
    private boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public String getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(final String createdDay) {
        this.createdDay = createdDay;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public CustomerDTO() {
        this.setType(CustomerDTO.DTO_NAME);
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", createdDay='" + createdDay + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", enabled=" + enabled +
                "} " + super.toString();
    }
}
