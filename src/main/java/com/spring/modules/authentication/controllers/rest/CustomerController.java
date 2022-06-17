package com.spring.modules.authentication.controllers.rest;

import com.spring.core.controller.rest.ATypeManagementRestController;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.facades.ERole;
import com.spring.modules.authentication.facades.imps.CustomerFacade;
import com.spring.modules.authentication.models.CustomerModel;
import com.spring.modules.authentication.services.CustomerService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

@RestController
@RequestMapping("/customer")
public class CustomerController extends ATypeManagementRestController<CustomerDTO, CustomerModel, CustomerService, CustomerFacade> {

    protected CustomerController(final CustomerFacade facade) {
        super(facade);
    }

   @Override
    public CustomerDTO create(@Parameter(in = ParameterIn.DEFAULT,required = true) @RequestBody CustomerDTO entity) {
        if(Objects.nonNull(entity)) {
            if(StringUtils.isBlank(entity.getCode())) {
                entity.setCode(getFacade().generatorCode(CustomerModel.MODEL_NAME));
            }

            entity.setPassword(new BCryptPasswordEncoder().encode(entity.getPassword()));
            entity.setCreatedDay(new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()));
            entity.setEnabled(true);
            entity.setRole(ERole.CUSTOMER.toString());

            CustomerDTO dtoCreated = getFacade().create(entity);

            return dtoCreated;
        }

        return null;
    }
}

