package com.spring.modules.product.facades.converts.model2dto;

import com.spring.core.facedes.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.product.controllers.dto.ProductDTO;
import com.spring.modules.product.models.ProductModel;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductModel2ProductDTOConverter extends AModel2DTOConverter<ProductModel, ProductDTO> {

    @Override
    public ProductDTO convert(ProductModel product) {
        if(Objects.nonNull(product)) {
            final ProductDTO product = super.convert(product);
            product.setImage(product.getImage());
            product.setPrice(product.getPrice());
            product.setName(product.getName());
            product.setQuantityStock(product.getQuantityStock());

            return product;
        }
        return null;
    }
}
