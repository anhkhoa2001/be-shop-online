package com.spring.modules.authentication.models;

import com.spring.core.model.AItemModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerModel extends AItemModel implements UserDetails {

    public static final String MODEL_NAME = "Customer";

    @Basic
    private String name;

    @Column(unique = true)
    private String username;

    @Basic
    private String password;

    @Basic
    private String address;

    @Basic
    private String role;

    @Basic
    private String createdDay;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Basic
    private boolean enabled;

    public CustomerModel(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public CustomerModel() {}

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setUsername(final String username) {
        this.username = username;
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

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(this.getRole().toString()));
        return grantedAuthorities;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                "} ";
    }
}
