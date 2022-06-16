package com.spring.modules.product.facades.converts.dto2model;

import com.spring.core.facedes.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.product.controllers.dto.LaptopDTO;
import com.spring.modules.product.models.LaptopModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LaptopDTO2LaptopModelConverter extends ADTO2ModelConverter<LaptopDTO, LaptopModel> {

    private final ProductDTO2ProductModelConverter productDTO2ProductModel;

    @Autowired
    public LaptopDTO2LaptopModelConverter(final ProductDTO2ProductModelConverter productDTO2ProductModel) {
        super(new LaptopModel());
        this.productDTO2ProductModel = productDTO2ProductModel;
    }

    @Override
    public LaptopModel convert(LaptopDTO laptopDTO) {
        if(Objects.nonNull(laptopDTO)) {
            final LaptopModel laptop = (LaptopModel) getProductDTO2ProductModel().convert(laptopDTO);
            if(!StringUtils.isBlank(laptopDTO.getRam())) {
                laptop.setRam(laptopDTO.getRam());
            }
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

    public ProductDTO2ProductModelConverter getProductDTO2ProductModel() {
        return productDTO2ProductModel;
    }
}
