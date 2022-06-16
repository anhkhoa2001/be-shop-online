package com.spring.modules.product.facades.impls;

import com.spring.core.facedes.converter.dto2model.ADTO2ModelConverter;
import com.spring.core.facedes.converter.model2dto.AModel2DTOConverter;
import com.spring.core.facedes.impls.ATypeManagementFacade;
import com.spring.modules.product.controllers.dto.ProductDTO;
import com.spring.modules.product.models.ProductModel;
import com.spring.modules.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductFacade extends ATypeManagementFacade<ProductDTO, ProductModel, ProductService> {

    @Autowired
    public ProductFacade(final ProductService service,
                         final ADTO2ModelConverter<ProductDTO, ProductModel> dto2model,
                         final AModel2DTOConverter<ProductModel, ProductDTO> model2dto) {
        super(service, dto2model, model2dto);
    }
}
