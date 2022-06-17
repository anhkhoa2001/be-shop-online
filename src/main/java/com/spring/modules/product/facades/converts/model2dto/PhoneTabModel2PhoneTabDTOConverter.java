package com.spring.modules.product.facades.converts.model2dto;

import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.category.facades.converters.dto2model.model2dto.CategoryModel2CategoryDTOConverter;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.models.PhoneTabModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;

@Component
public class PhoneTabModel2PhoneTabDTOConverter extends AModel2DTOConverter<PhoneTabModel, PhoneTabDTO> {

    private final CategoryModel2CategoryDTOConverter categoryModel2CategoryDTO;

    @Autowired
    public PhoneTabModel2PhoneTabDTOConverter(final CategoryModel2CategoryDTOConverter categoryModel2CategoryDTO) {
        super(new PhoneTabDTO());
        this.categoryModel2CategoryDTO = categoryModel2CategoryDTO;
    }

    @Override
    public PhoneTabDTO convert(PhoneTabModel phoneTab) {
        if(Objects.nonNull(phoneTab)) {
            final PhoneTabDTO phoneTabDTO = new PhoneTabDTO();
            phoneTabDTO.setCode(phoneTab.getCode());
            phoneTabDTO.setId(phoneTab.getId());
            phoneTabDTO.setName(phoneTab.getName());
            phoneTabDTO.setQuantityStock(phoneTab.getQuantityStock());
            phoneTabDTO.setPrice(phoneTab.getPrice());

            if(!StringUtils.isBlank(phoneTab.getImage())) {
                phoneTabDTO.setImage(phoneTab.getImage());
            }
            if(!StringUtils.isBlank(phoneTab.getName())) {
                phoneTabDTO.setName(phoneTab.getName());
            }

            if(Objects.nonNull(phoneTab.getCategory())) {
                phoneTabDTO.setCategoryDTO(getCategoryModel2CategoryDTO().convert(phoneTab.getCategory()));
                phoneTabDTO.getCategoryDTO().setProductDTOs(Collections.emptyList());
            }
            if(!StringUtils.isBlank(phoneTab.getChip())) {
                phoneTabDTO.setChip(phoneTab.getChip());
            }
            if(!StringUtils.isBlank(phoneTab.getDisplay())) {
                phoneTabDTO.setDisplay(phoneTab.getDisplay());
            }
            if(!StringUtils.isBlank(phoneTab.getRam())) {
                phoneTabDTO.setRam(phoneTab.getRam());
            }
            if(!StringUtils.isBlank(phoneTab.getFrontCamera())) {
                phoneTabDTO.setFrontCamera(phoneTab.getFrontCamera());
            }
            if(!StringUtils.isBlank(phoneTab.getBackCamera())) {
                phoneTabDTO.setBackCamera(phoneTab.getBackCamera());
            }
            if(!StringUtils.isBlank(phoneTab.getMemory())) {
                phoneTabDTO.setMemory(phoneTab.getMemory());
            }

            return phoneTabDTO;
        }
        return null;
    }

    public CategoryModel2CategoryDTOConverter getCategoryModel2CategoryDTO() {
        return categoryModel2CategoryDTO;
    }
}
