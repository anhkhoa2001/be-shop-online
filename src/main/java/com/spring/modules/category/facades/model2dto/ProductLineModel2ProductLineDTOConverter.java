package com.spring.modules.category.facades.model2dto;

import com.spring.core.facedes.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.category.controller.dtos.ProductLineDTO;
import com.spring.modules.category.model.ProductLineModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Objects;

@Component
public class ProductLineModel2ProductLineDTOConverter extends AModel2DTOConverter<ProductLineModel, ProductLineDTO> {

    public ProductLineModel2ProductLineDTOConverter() {
        super(new ProductLineDTO());
    }

    @Override
    public ProductLineDTO convert(ProductLineModel productLine) {
        if(Objects.nonNull(productLine)) {
            final ProductLineDTO productLineDTO = new ProductLineDTO();
            productLineDTO.setCode(productLine.getCode());
            productLineDTO.setId(productLine.getId());
            if(!StringUtils.isBlank(productLine.getLine())) {
                productLineDTO.setLine(productLine.getLine());
            }

            if(!StringUtils.isBlank(productLine.getImage())) {
                productLineDTO.setImage(productLine.getImage());
            }

            if(!StringUtils.isBlank(productLine.getIcon())) {
                productLineDTO.setIcon(productLine.getIcon());
            }

            if(!StringUtils.isBlank(productLine.getSlogan())) {
                productLineDTO.setSlogan(productLine.getSlogan());
            }

/*            if(!CollectionUtils.isEmpty(productLine.getCategories())) {
                productLineDTO.setCategoryDTOs(getCategoryModel2CategoryDTO().convertSet2List(productLine.getCategories()));
                productLineDTO.getCategoryDTOs().forEach(e -> {
                    e.setProductLineDTO(null);
                });
            }*/

            return productLineDTO;
        }
        return null;
    }
}
