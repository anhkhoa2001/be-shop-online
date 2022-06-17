package com.spring.modules.authentication.facades.dto2model;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.models.CustomerModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerDTO2CustomerModelConverter extends ADTO2ModelConverter<CustomerDTO, CustomerModel> {

    @Autowired
    public CustomerDTO2CustomerModelConverter() {
        super(new CustomerModel());
    }

    @Override
    public CustomerModel convert(CustomerDTO customerDTO) {
        if(Objects.nonNull(customerDTO)) {
            final CustomerModel customer = new CustomerModel();
            if(!StringUtils.isBlank(customerDTO.getCode())) {
                customer.setCode(customerDTO.getCode());
            }
            if(!StringUtils.isBlank(customerDTO.getUsername())) {
                customer.setUsername(customerDTO.getUsername());
            }
            if(!StringUtils.isBlank(customerDTO.getPassword())) {
                customer.setPassword(customerDTO.getPassword());
            }
            if(!StringUtils.isBlank(customerDTO.getAddress())) {
                customer.setAddress(customerDTO.getAddress());
            }
            if(!StringUtils.isBlank(customerDTO.getPhone())) {
                customer.setPhone(customerDTO.getPhone());
            }
            if(!StringUtils.isBlank(customerDTO.getName())) {
                customer.setName(customerDTO.getName());
            }
            customer.setRole(customerDTO.getRole());
            if(!StringUtils.isBlank(customerDTO.getEmail())) {
                customer.setEmail(customerDTO.getEmail());
            }
            if(!StringUtils.isBlank(customerDTO.getCreatedDay())) {
                customer.setCreatedDay(customerDTO.getCreatedDay());
            }
            customer.setEnabled(customerDTO.isEnabled());

            return customer;
        }
        return null;
    }
}
