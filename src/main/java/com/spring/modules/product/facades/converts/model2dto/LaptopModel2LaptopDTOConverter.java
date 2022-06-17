package com.spring.modules.product.facades.converts.model2dto;

import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.category.facades.converters.dto2model.model2dto.CategoryModel2CategoryDTOConverter;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.models.LaptopModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;

@Component
public class LaptopModel2LaptopDTOConverter extends AModel2DTOConverter<LaptopModel, LaptopDTO> {

    private final CategoryModel2CategoryDTOConverter categoryModel2CategoryDTO;

    @Autowired
    public LaptopModel2LaptopDTOConverter(final CategoryModel2CategoryDTOConverter categoryModel2CategoryDTO) {
        super(new LaptopDTO());
        this.categoryModel2CategoryDTO = categoryModel2CategoryDTO;
    }

    @Override
    public LaptopDTO convert(LaptopModel laptop) {
        if(Objects.nonNull(laptop)) {
            final LaptopDTO laptopDTO = new LaptopDTO();
            laptopDTO.setCode(laptop.getCode());
            laptopDTO.setId(laptop.getId());
            laptopDTO.setName(laptop.getName());
            laptopDTO.setQuantityStock(laptop.getQuantityStock());
            laptopDTO.setPrice(laptop.getPrice());

            if(!StringUtils.isBlank(laptop.getImage())) {
                laptopDTO.setImage(laptop.getImage());
            }
            if(!StringUtils.isBlank(laptop.getName())) {
                laptopDTO.setName(laptop.getName());
            }

            if(Objects.nonNull(laptop.getCategory())) {
                laptopDTO.setCategoryDTO(getCategoryModel2CategoryDTO().convert(laptop.getCategory()));
                laptopDTO.getCategoryDTO().setProductDTOs(Collections.emptyList());
            }

            if(!StringUtils.isBlank(laptop.getRam())) {
                laptopDTO.setRam(laptop.getRam());
            }
            if(!StringUtils.isBlank(laptop.getSize())) {
                laptopDTO.setSize(laptop.getSize());
            }
            laptopDTO.setWeight(laptop.getWeight());
            if(!StringUtils.isBlank(laptop.getCard())) {
                laptopDTO.setCard(laptop.getCard());
            }
            if(!StringUtils.isBlank(laptop.getDisplay())) {
                laptopDTO.setDisplay(laptop.getDisplay());
            }
            if(!StringUtils.isBlank(laptop.getCpu())) {
                laptopDTO.setCpu(laptop.getCpu());
            }
            if(!StringUtils.isBlank(laptop.getMemory())) {
                laptopDTO.setMemory(laptop.getMemory());
            }

            return laptopDTO;
        }
        return null;
    }

    public CategoryModel2CategoryDTOConverter getCategoryModel2CategoryDTO() {
        return categoryModel2CategoryDTO;
    }
}

