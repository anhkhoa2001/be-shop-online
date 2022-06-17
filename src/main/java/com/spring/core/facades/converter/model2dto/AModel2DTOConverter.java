package com.spring.core.facades.converter.model2dto;

import com.spring.core.controller.dto.AItemDTO;
import com.spring.core.facades.converter.AConverter;
import com.spring.core.model.AItemModel;

public class AModel2DTOConverter<SOURCE extends AItemModel, TARGET extends AItemDTO> extends AConverter<SOURCE, TARGET>{

    public AModel2DTOConverter(final TARGET target) {
        super(target);
    }

}
