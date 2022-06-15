package com.spring.modules.product.facades.converts.dto2model;

import com.spring.core.facedes.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.product.controllers.dto.ProductDTO;
import com.spring.modules.product.models.ProductModel;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductDTO2ProductModelConverter extends ADTO2ModelConverter<ProductDTO, ProductModel> {

    @Override
    public ProductModel convert(ProductDTO productDTO) {
        if(Objects.nonNull(productDTO)) {
            final ProductModel product = super.convert(productDTO);
            product.setImage(productDTO.getImage());
            product.setPrice(productDTO.getPrice());
            product.setName(productDTO.getName());
            product.setQuantityStock(productDTO.getQuantityStock());

            return product;
        }
        return null;
    }
}
