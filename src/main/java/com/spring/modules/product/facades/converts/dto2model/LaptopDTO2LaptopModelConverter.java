package com.spring.modules.product.facades.converts.dto2model;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.category.facades.converters.dto2model.CategoryDTO2CategoryModelConverter;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.models.LaptopModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;

@Component
public class LaptopDTO2LaptopModelConverter extends ADTO2ModelConverter<LaptopDTO, LaptopModel> {

    private final CategoryDTO2CategoryModelConverter categoryDTO2CategoryModel;

    @Autowired
    public LaptopDTO2LaptopModelConverter(final CategoryDTO2CategoryModelConverter categoryDTO2CategoryModel) {
        super(new LaptopModel());
        this.categoryDTO2CategoryModel = categoryDTO2CategoryModel;
    }

    @Override
    public LaptopModel convert(LaptopDTO laptopDTO) {
        if(Objects.nonNull(laptopDTO)) {
            final LaptopModel laptop = new LaptopModel();
            laptop.setCode(laptopDTO.getCode());
            laptop.setId(laptopDTO.getId());
            laptop.setName(laptopDTO.getName());
            laptop.setQuantityStock(laptopDTO.getQuantityStock());

            if(!StringUtils.isBlank(laptopDTO.getImage())) {
                laptop.setImage(laptopDTO.getImage());
            }
            if(!StringUtils.isBlank(laptopDTO.getName())) {
                laptop.setName(laptopDTO.getName());
            }

            if(Objects.nonNull(laptopDTO.getCategoryDTO())) {
                laptop.setCategory(getCategoryDTO2CategoryModel().convert(laptopDTO.getCategoryDTO()));
                laptop.getCategory().setProducts(Collections.emptySet());
            }
            if(!StringUtils.isBlank(laptopDTO.getRam())) {
                laptop.setRam(laptopDTO.getRam());
            }
            laptop.setPrice(laptopDTO.getPrice());
            if(!StringUtils.isBlank(laptopDTO.getSize())) {
                laptop.setSize(laptopDTO.getSize());
            }
            laptop.setWeight(laptopDTO.getWeight());
            if(!StringUtils.isBlank(laptopDTO.getCard())) {
                laptop.setCard(laptopDTO.getCard());
            }
            if(!StringUtils.isBlank(laptopDTO.getDisplay())) {
                laptop.setDisplay(laptopDTO.getDisplay());
            }
            if(!StringUtils.isBlank(laptopDTO.getCpu())) {
                laptop.setCpu(laptopDTO.getCpu());
            }
            if(!StringUtils.isBlank(laptopDTO.getMemory())) {
                laptop.setMemory(laptopDTO.getMemory());
            }

            return laptop;
        }
        return null;
    }

    public CategoryDTO2CategoryModelConverter getCategoryDTO2CategoryModel() {
        return categoryDTO2CategoryModel;
    }
}
