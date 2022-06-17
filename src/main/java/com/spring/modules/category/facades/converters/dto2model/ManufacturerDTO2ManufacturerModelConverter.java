package com.spring.modules.category.facades.converters.dto2model;

import com.spring.core.facades.converter.dto2model.ADTO2ModelConverter;
import com.spring.modules.category.controller.dtos.ManufacturerDTO;
import com.spring.modules.category.model.ManufacturerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ManufacturerDTO2ManufacturerModelConverter extends ADTO2ModelConverter<ManufacturerDTO, ManufacturerModel> {

    @Autowired
    public ManufacturerDTO2ManufacturerModelConverter() {
        super(new ManufacturerModel());
    }

    @Override
    public ManufacturerModel convert(ManufacturerDTO manufacturerDTO) {
        if(Objects.nonNull(manufacturerDTO)) {
            final ManufacturerModel manufacturer = super.convert(manufacturerDTO);
            manufacturer.setName(manufacturerDTO.getName());

            return manufacturer;
        }
        return null;
    }
}
