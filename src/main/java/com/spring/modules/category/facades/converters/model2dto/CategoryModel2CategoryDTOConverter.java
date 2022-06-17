package com.spring.modules.category.facades.converters.dto2model.model2dto;

import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.model.CategoryModel;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CategoryModel2CategoryDTOConverter extends AModel2DTOConverter<CategoryModel, CategoryDTO> {

    private final ProductLineModel2ProductLineDTOConverter productLineModel2ProductLineDTO;
    private final ManufacturerModel2ManufacturerDTOConverter manufacturerModel2ManufacturerDTO;

    public CategoryModel2CategoryDTOConverter(final ProductLineModel2ProductLineDTOConverter productLineModel2ProductLineDTO, final ManufacturerModel2ManufacturerDTOConverter manufacturerModel2ManufacturerDTO) {
        super(new CategoryDTO());
        this.productLineModel2ProductLineDTO = productLineModel2ProductLineDTO;
        this.manufacturerModel2ManufacturerDTO = manufacturerModel2ManufacturerDTO;
    }


    public ProductLineModel2ProductLineDTOConverter getProductLineModel2ProductLineDTO() {
        return productLineModel2ProductLineDTO;
    }

    public ManufacturerModel2ManufacturerDTOConverter getManufacturerModel2ManufacturerDTO() {
        return manufacturerModel2ManufacturerDTO;
    }

    @Override
    public CategoryDTO convert(CategoryModel category) {
        if(Objects.nonNull(category)) {
            final CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCode(category.getCode());
            categoryDTO.setId(category.getId());
            categoryDTO.setLine(category.getLine());
            categoryDTO.setLogo(category.getLogo());
            categoryDTO.setCategoryCode(category.getCategoryCode());
            if(Objects.nonNull(category.getProductLine())) {
                categoryDTO.setProductLineDTO(getProductLineModel2ProductLineDTO().convert(category.getProductLine()));
            }

            if(Objects.nonNull(category.getManufacturer())) {
                categoryDTO.setManufacturerDTO(getManufacturerModel2ManufacturerDTO().convert(category.getManufacturer()));
            }

            return categoryDTO;
        }
        return null;
    }
}
