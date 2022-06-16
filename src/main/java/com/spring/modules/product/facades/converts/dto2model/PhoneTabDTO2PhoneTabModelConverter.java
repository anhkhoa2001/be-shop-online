package com.spring.modules.product.facades.converts.dto2model;

import com.spring.core.facedes.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.models.PhoneTabModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PhoneTabDTO2PhoneTabModelConverter extends ADTO2ModelConverter<PhoneTabDTO, PhoneTabModel> {

    private final ProductDTO2ProductModelConverter productDTO2ProductModel;

    @Autowired
    public PhoneTabDTO2PhoneTabModelConverter(final ProductDTO2ProductModelConverter productDTO2ProductModel) {
        super(new PhoneTabModel());
        this.productDTO2ProductModel = productDTO2ProductModel;
    }

    @Override
    public PhoneTabModel convert(PhoneTabDTO phoneTabDTO) {
        if(Objects.nonNull(phoneTabDTO)) {
            final PhoneTabModel phoneTab = (PhoneTabModel) getProductDTO2ProductModel().convert(phoneTabDTO);
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

    public ProductDTO2ProductModelConverter getProductDTO2ProductModel() {
        return productDTO2ProductModel;
    }
}
