package com.spring.modules.product.facades.converts.model2dto;

import com.spring.core.facedes.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.facades.converts.dto2model.ProductDTO2ProductModelConverter;
import com.spring.modules.product.models.PhoneTabModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PhoneTabModel2PhoneTabDTOConverter extends AModel2DTOConverter<PhoneTabModel, PhoneTabDTO> {

    private final ProductModel2ProductDTOConverter productModel2ProductDTO;

    @Autowired
    public PhoneTabModel2PhoneTabDTOConverter(final ProductModel2ProductDTOConverter productModel2ProductDTO) {
        super(new PhoneTabDTO());
        this.productModel2ProductDTO = productModel2ProductDTO;
    }

    @Override
    public PhoneTabDTO convert(PhoneTabModel phoneTab) {
        if(Objects.nonNull(phoneTab)) {
            final PhoneTabDTO phoneTabDTO = (PhoneTabDTO) getProductModel2ProductDTO().convert(phoneTab);
            phoneTabDTO.setType(PhoneTabDTO.DTO_NAME);
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

    public ProductModel2ProductDTOConverter getProductModel2ProductDTO() {
        return productModel2ProductDTO;
    }
}
