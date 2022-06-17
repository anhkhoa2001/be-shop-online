package com.spring.modules.category.facades.imps;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facades.impls.ATypeManagementFacade;
import com.spring.modules.category.controller.dtos.ManufacturerDTO;
import com.spring.modules.category.model.ManufacturerModel;
import com.spring.modules.category.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerFacade extends ATypeManagementFacade<ManufacturerDTO, ManufacturerModel, ManufacturerService> {

    @Autowired
    public ManufacturerFacade(final ManufacturerService service,
                          final ADTO2ModelConverter<ManufacturerDTO, ManufacturerModel> dto2model,
                          final AModel2DTOConverter<ManufacturerModel, ManufacturerDTO> model2dto) {
        super(service, dto2model, model2dto);
    }
}
