package com.spring.modules.product.facades.converts.dto2model;

import com.spring.core.facedes.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.product.controllers.dto.PhoneTabDTO;
import com.spring.modules.product.models.PhoneTabModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PhoneTabDTO2PhoneTabModelConverter extends ADTO2ModelConverter<PhoneTabDTO, PhoneTabModel> {

    private final PhoneTabDTO2PhoneTabModelConverter phoneTabDTO2PhoneTabModelConverter;

    @Autowired
    public PhoneTabDTO2PhoneTabModelConverter(final PhoneTabDTO2PhoneTabModelConverter phoneTabDTO2PhoneTabModelConverter) {
        this.phoneTabDTO2PhoneTabModelConverter = phoneTabDTO2PhoneTabModelConverter;
    }

    @Override
    public PhoneTabModel convert(PhoneTabDTO phoneTabDTO) {
        if(Objects.nonNull(phoneTabDTO)) {
            final PhoneTabModel phoneTab = (PhoneTabModel) getPhoneTabDTO2PhoneTabModelConverter().convert(phoneTabDTO);
            phoneTab.setChip(phoneTabDTO.getChip());
            phoneTab.setRam(phoneTabDTO.getRam());
            phoneTab.setBackCamera(phoneTabDTO.getBackCamera());
            phoneTab.setFrontCamera(phoneTabDTO.getFrontCamera());
            phoneTab.setDisplay(phoneTabDTO.getDisplay());
            phoneTab.setMemory(phoneTabDTO.getMemory());

            return phoneTab;
        }
        return null;
    }

    public PhoneTabDTO2PhoneTabModelConverter getPhoneTabDTO2PhoneTabModelConverter() {
        return phoneTabDTO2PhoneTabModelConverter;
    }
}
