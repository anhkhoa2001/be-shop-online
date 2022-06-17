package com.spring.modules.authentication.facades.imps;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.modules.authentication.controllers.dtos.CustomerDTO;
import com.spring.modules.authentication.models.CustomerModel;
import com.spring.modules.authentication.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerFacade extends ATypeManagementFacade<CustomerDTO, CustomerModel, CustomerService> {

    @Autowired
    public CustomerFacade(final CustomerService service,
                          final ADTO2ModelConverter<CustomerDTO, CustomerModel> dto2model,
                          final AModel2DTOConverter<CustomerModel, CustomerDTO> model2dto) {
        super(service, dto2model, model2dto);
    }

    public CustomerDTO getByUsername(final String username) {
        return getModel2dto().convert(getService().findByUsername(username));
    }
}