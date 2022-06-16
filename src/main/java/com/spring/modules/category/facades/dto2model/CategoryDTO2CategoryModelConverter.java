package com.spring.modules.category.facades.dto2model;

import com.spring.core.facedes.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CategoryDTO2CategoryModelConverter extends ADTO2ModelConverter<CategoryDTO, CategoryModel> {
    private final ProductLineDTO2ProductLineModelConverter productLineDTO2ProductLineModel;
    private final ManufacturerDTO2ManufacturerModelConverter manufacturerDTO2ManufacturerModel;

    @Autowired
    public CategoryDTO2CategoryModelConverter(final ProductLineDTO2ProductLineModelConverter productLineDTO2ProductLineModel, final ManufacturerDTO2ManufacturerModelConverter manufacturerDTO2ManufacturerModel) {
        super(new CategoryModel());
        this.productLineDTO2ProductLineModel = productLineDTO2ProductLineModel;
        this.manufacturerDTO2ManufacturerModel = manufacturerDTO2ManufacturerModel;
    }

    @Override
    public CategoryModel convert(CategoryDTO categoryDTO) {
        if(Objects.nonNull(categoryDTO)) {
            final CategoryModel category = new CategoryModel();
            category.setCode(categoryDTO.getCode());
            category.setId(categoryDTO.getId());
            category.setLine(categoryDTO.getLine());
            category.setLogo(categoryDTO.getLogo());
            category.setCategoryCode(categoryDTO.getCategoryCode());

            if(Objects.nonNull(categoryDTO.getProductLineDTO())) {
                category.setProductLine(getProductLineDTO2ProductLineModel().convert(categoryDTO.getProductLineDTO()));
            }

            if(Objects.nonNull(categoryDTO.getManufacturerDTO())) {
                category.setManufacturer(getManufacturerDTO2ManufacturerModel().convert(categoryDTO.getManufacturerDTO()));
            }

            return category;
        }
        return null;
    }

    private ProductLineDTO2ProductLineModelConverter getProductLineDTO2ProductLineModel() {
        return productLineDTO2ProductLineModel;
    }

    private ManufacturerDTO2ManufacturerModelConverter getManufacturerDTO2ManufacturerModel() {
        return manufacturerDTO2ManufacturerModel;
    }
}
