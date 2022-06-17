package com.spring.modules.product.facades.converts.dto2model;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.category.facades.converters.dto2model.CategoryDTO2CategoryModelConverter;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.models.PhoneTabModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;

@Component
public class PhoneTabDTO2PhoneTabModelConverter extends ADTO2ModelConverter<PhoneTabDTO, PhoneTabModel> {

    private final CategoryDTO2CategoryModelConverter categoryDTO2CategoryModel;

    @Autowired
    public PhoneTabDTO2PhoneTabModelConverter(final CategoryDTO2CategoryModelConverter categoryDTO2CategoryModel) {
        super(new PhoneTabModel());
        this.categoryDTO2CategoryModel = categoryDTO2CategoryModel;
    }

    @Override
    public PhoneTabModel convert(PhoneTabDTO phoneTabDTO) {
        if(Objects.nonNull(phoneTabDTO)) {
            final PhoneTabModel phoneTab = new PhoneTabModel();
            phoneTab.setCode(phoneTabDTO.getCode());
            phoneTab.setId(phoneTabDTO.getId());
            phoneTab.setName(phoneTabDTO.getName());
            phoneTab.setQuantityStock(phoneTabDTO.getQuantityStock());

            if(!StringUtils.isBlank(phoneTabDTO.getImage())) {
                phoneTab.setImage(phoneTabDTO.getImage());
            }
            if(!StringUtils.isBlank(phoneTabDTO.getName())) {
                phoneTab.setName(phoneTabDTO.getName());
            }

            if(Objects.nonNull(phoneTabDTO.getCategoryDTO())) {
                phoneTab.setCategory(getCategoryDTO2CategoryModel().convert(phoneTabDTO.getCategoryDTO()));
                phoneTab.getCategory().setProducts(Collections.emptySet());
            }
            phoneTab.setPrice(phoneTabDTO.getPrice());

            if(!StringUtils.isBlank(phoneTabDTO.getChip())) {
                phoneTab.setChip(phoneTabDTO.getChip());
            }
            if(!StringUtils.isBlank(phoneTabDTO.getDisplay())) {
                phoneTab.setDisplay(phoneTabDTO.getDisplay());
            }
            if(!StringUtils.isBlank(phoneTabDTO.getRam())) {
                phoneTab.setRam(phoneTabDTO.getRam());
            }
            if(!StringUtils.isBlank(phoneTabDTO.getFrontCamera())) {
                phoneTab.setFrontCamera(phoneTabDTO.getFrontCamera());
            }
            if(!StringUtils.isBlank(phoneTabDTO.getBackCamera())) {
                phoneTab.setBackCamera(phoneTabDTO.getBackCamera());
            }
            if(!StringUtils.isBlank(phoneTabDTO.getMemory())) {
                phoneTab.setMemory(phoneTabDTO.getMemory());
            }

            return phoneTab;
        }
        return null;
    }

    public CategoryDTO2CategoryModelConverter getCategoryDTO2CategoryModel() {
        return categoryDTO2CategoryModel;
    }
}
