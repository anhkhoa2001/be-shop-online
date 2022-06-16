package com.spring.modules.category.controller.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.core.controller.dto.AItemDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Schema(title = ManufacturerDTO.DTO_NAME, description = "Data transfer object for " + ManufacturerDTO.DTO_NAME)
public class ManufacturerDTO extends AItemDTO {

    public static final String DTO_NAME = "ManufacturerDTO";

    @Schema(example = DTO_NAME, required = true)
    private String type;

    @Schema(example = "Apple")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ManufacturerDTO{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
