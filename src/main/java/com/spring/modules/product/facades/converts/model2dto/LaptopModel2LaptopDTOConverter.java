package com.spring.modules.product.facades.converts.model2dto;

import com.spring.core.facedes.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.models.LaptopModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LaptopModel2LaptopDTOConverter extends AModel2DTOConverter<LaptopModel, LaptopDTO> {

    private final ProductModel2ProductDTOConverter productModel2ProductDTO;

    @Autowired
    public LaptopModel2LaptopDTOConverter(final ProductModel2ProductDTOConverter productModel2ProductDTO) {
        super(new LaptopDTO());
        this.productModel2ProductDTO = productModel2ProductDTO;
    }

    @Override
    public LaptopDTO convert(LaptopModel laptop) {
        if(Objects.nonNull(laptop)) {
            final LaptopDTO laptopDTO = (LaptopDTO) getProductModel2ProductDTO().convert(laptop);
            laptopDTO.setType(LaptopDTO.DTO_NAME);
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

    public ProductModel2ProductDTOConverter getProductModel2ProductDTO() {
        return productModel2ProductDTO;
    }
}

