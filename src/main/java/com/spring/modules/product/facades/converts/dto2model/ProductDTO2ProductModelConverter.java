package com.spring.modules.product.facades.converts.dto2model;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.category.facades.converters.dto2model.CategoryDTO2CategoryModelConverter;
import com.spring.modules.product.controllers.dto.ProductDTO;
import com.spring.modules.product.models.ProductModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;

@Component
public class ProductDTO2ProductModelConverter extends ADTO2ModelConverter<ProductDTO, ProductModel> {

    private final CategoryDTO2CategoryModelConverter categoryDTO2CategoryModel;

    public ProductDTO2ProductModelConverter(final CategoryDTO2CategoryModelConverter categoryDTO2CategoryModel) {
        super(new ProductModel());
        this.categoryDTO2CategoryModel = categoryDTO2CategoryModel;
    }

    @Override
    public ProductModel convert(ProductDTO productDTO) {
        if(Objects.nonNull(productDTO)) {
            final ProductModel product = new ProductModel();
            product.setCode(productDTO.getCode());
            product.setId(productDTO.getId());
            product.setName(productDTO.getName());
            product.setQuantityStock(productDTO.getQuantityStock());

            if(!StringUtils.isBlank(productDTO.getImage())) {
                product.setImage(productDTO.getImage());
            }
            if(!StringUtils.isBlank(productDTO.getName())) {
                product.setName(productDTO.getName());
            }

            if(Objects.nonNull(productDTO.getCategoryDTO())) {
                product.setCategory(getCategoryDTO2CategoryModel().convert(productDTO.getCategoryDTO()));
                product.getCategory().setProducts(Collections.emptySet());
            }

            return product;
        }
        return null;
    }

    public CategoryDTO2CategoryModelConverter getCategoryDTO2CategoryModel() {
        return categoryDTO2CategoryModel;
    }
}
