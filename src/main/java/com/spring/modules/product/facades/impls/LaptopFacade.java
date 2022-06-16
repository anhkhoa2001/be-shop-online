package com.spring.modules.product.facades.impls;

import com.spring.core.facedes.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facedes.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facedes.impls.ATypeManagementFacade;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.models.LaptopModel;
import com.spring.modules.product.models.PhoneTabModel;
import com.spring.modules.product.services.LaptopService;
import com.spring.modules.product.services.PhoneTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LaptopFacade extends ATypeManagementFacade<LaptopDTO, LaptopModel, LaptopService> {

    @Autowired
    public LaptopFacade(final LaptopService service,
                          final ADTO2ModelConverter<LaptopDTO, LaptopModel> dto2model,
                          final AModel2DTOConverter<LaptopModel, LaptopDTO> model2dto) {
        super(service, dto2model, model2dto);
    }
}
