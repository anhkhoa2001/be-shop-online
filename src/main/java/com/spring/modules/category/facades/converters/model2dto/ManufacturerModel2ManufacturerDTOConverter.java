package com.spring.modules.category.facades.converters.dto2model.model2dto;

import com.spring.core.facades.converter.model2dto.AModel2DTOConverter;
import com.spring.modules.category.controller.dtos.ManufacturerDTO;
import com.spring.modules.category.model.ManufacturerModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ManufacturerModel2ManufacturerDTOConverter extends AModel2DTOConverter<ManufacturerModel, ManufacturerDTO> {

    public ManufacturerModel2ManufacturerDTOConverter() {
        super(new ManufacturerDTO());
    }

    @Override
    public ManufacturerDTO convert(ManufacturerModel manufacturer) {
        if(Objects.nonNull(manufacturer)) {
            final ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
            manufacturerDTO.setId(manufacturer.getId());
            manufacturerDTO.setName(manufacturer.getName());
            manufacturerDTO.setType(ManufacturerDTO.DTO_NAME);
            if(!StringUtils.isBlank(manufacturer.getCode())) {
                manufacturerDTO.setCode(manufacturer.getCode());
            }

            return manufacturerDTO;
        }
        return null;
    }
}
