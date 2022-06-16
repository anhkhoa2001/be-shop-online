package com.spring.modules.category.facades.imps;

import com.spring.core.facedes.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facedes.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facedes.impls.ATypeManagementFacade;
import com.spring.modules.category.controller.dtos.ProductLineDTO;
import com.spring.modules.category.model.ProductLineModel;
import com.spring.modules.category.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductLineFacade extends ATypeManagementFacade<ProductLineDTO, ProductLineModel, ProductLineService> {

    @Autowired
    public ProductLineFacade(final ProductLineService service,
                             final ADTO2ModelConverter<ProductLineDTO, ProductLineModel> dto2model,
                             final AModel2DTOConverter<ProductLineModel, ProductLineDTO> model2dto) {
        super(service, dto2model, model2dto);
    }
}
