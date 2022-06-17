package com.spring.modules.product.facades.converts.model2dto;

import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.category.facades.converters.dto2model.model2dto.CategoryModel2CategoryDTOConverter;
import com.spring.modules.product.controllers.dto.ProductDTO;
import com.spring.modules.product.models.ProductModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;

@Component
public class ProductModel2ProductDTOConverter extends AModel2DTOConverter<ProductModel, ProductDTO> {

    @Autowired
    private CategoryModel2CategoryDTOConverter categoryModel2CategoryDTO;

    public ProductModel2ProductDTOConverter() {
        super(new ProductDTO());
    }

    @Override
    public ProductDTO convert(ProductModel product) {
        if(Objects.nonNull(product)) {
            final ProductDTO productDTO = new ProductDTO();
            productDTO.setCode(product.getCode());
            productDTO.setId(product.getId());
            if(!StringUtils.isBlank(product.getImage())) {
                productDTO.setImage(product.getImage());
            }
            if(!StringUtils.isBlank(product.getName())) {
                productDTO.setName(product.getName());
            }
            productDTO.setPrice(product.getPrice());
            productDTO.setQuantityStock(product.getQuantityStock());

            if(Objects.nonNull(product.getCategory())) {
                productDTO.setCategoryDTO(getCategoryModel2CategoryDTO().convert(product.getCategory()));
                productDTO.getCategoryDTO().setProductDTOs(Collections.emptyList());
            }
            return productDTO;
        }
        return null;
    }

    protected CategoryModel2CategoryDTOConverter getCategoryModel2CategoryDTO() {
        return categoryModel2CategoryDTO;
    }
}
