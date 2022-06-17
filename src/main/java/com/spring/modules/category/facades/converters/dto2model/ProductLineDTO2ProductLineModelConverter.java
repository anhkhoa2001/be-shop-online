package com.spring.modules.category.facades.converters.dto2model;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.category.controller.dtos.ProductLineDTO;
import com.spring.modules.category.model.ProductLineModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductLineDTO2ProductLineModelConverter extends ADTO2ModelConverter<ProductLineDTO, ProductLineModel> {

    public ProductLineDTO2ProductLineModelConverter() {
        super(new ProductLineModel());
    }

    @Override
    public ProductLineModel convert(ProductLineDTO productLineDTO) {
        if(Objects.nonNull(productLineDTO)) {
            final ProductLineModel productLine = new ProductLineModel();
            productLine.setCode(productLineDTO.getCode());
            productLine.setId(productLineDTO.getId());
            if(!StringUtils.isBlank(productLineDTO.getLine())) {
                productLine.setLine(productLineDTO.getLine());
            }

            if(!StringUtils.isBlank(productLineDTO.getImage())) {
                productLine.setImage(productLineDTO.getImage());
            }

            if(!StringUtils.isBlank(productLineDTO.getIcon())) {
                productLine.setIcon(productLineDTO.getIcon());
            }

            if(!StringUtils.isBlank(productLineDTO.getSlogan())) {
                productLine.setSlogan(productLineDTO.getSlogan());
            }

/*            if(!CollectionUtils.isEmpty(productLineDTO.getCategoryDTOs())) {
                productLine.setCategories(getCategoryDTO2CategoryModel().convertList2Set(productLineDTO.getCategoryDTOs()));
                productLine.getCategories().forEach(e -> {
                    e.setProductLine(null);
                });
            }*/

            return productLine;
        }
        return null;
    }
}
