package com.spring.modules.authentication.facades.model2dto;

import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.models.CustomerModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerModel2CustomerDTOConverter extends AModel2DTOConverter<CustomerModel, CustomerDTO> {

    @Autowired
    public CustomerModel2CustomerDTOConverter() {
        super(new CustomerDTO());
    }

    @Override
    public CustomerDTO convert(final CustomerModel customer) {
        if(Objects.nonNull(customer)) {
            final CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());

            if(!StringUtils.isBlank(customer.getUsername())) {
                customerDTO.setUsername(customer.getUsername());
            }
            if(!StringUtils.isBlank(customer.getPassword())) {
                customerDTO.setPassword(customer.getPassword());
            }
            customerDTO.setEnabled(customer.isEnabled());
            if(!StringUtils.isBlank(customer.getAddress())) {
                customerDTO.setAddress(customer.getAddress());
            }
            if(!StringUtils.isBlank(customer.getCode())) {
                customerDTO.setCode(customer.getCode());
            }
            if(!StringUtils.isBlank(customer.getPhone())) {
                customerDTO.setPhone(customer.getPhone());
            }
            if(!StringUtils.isBlank(customer.getName())) {
                customerDTO.setName(customer.getName());
            }
            customerDTO.setRole(customer.getRole());
            if(!StringUtils.isBlank(customer.getEmail())) {
                customerDTO.setEmail(customer.getEmail());
            }
            if(!StringUtils.isBlank(customer.getCreatedDay())) {
                customerDTO.setCreatedDay(customer.getCreatedDay());
            }

            return customerDTO;
        }
        return null;
    }
}
