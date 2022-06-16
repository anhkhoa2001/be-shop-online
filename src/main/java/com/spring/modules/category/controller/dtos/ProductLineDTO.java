package com.spring.modules.category.controller.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.core.controller.dto.AItemDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Schema(title = ProductLineDTO.DTO_NAME, description = "Data transfer object for " + ProductLineDTO.DTO_NAME)
public class ProductLineDTO extends AItemDTO {

    public static final String DTO_NAME = "ProductLineDTO";

    @Schema(example = DTO_NAME, required = true)
    private String type;

    @Schema(example = "fas fa-mobile-alt")
    private String icon;

    @Schema(example = "image.png")
    private String image;

    @Schema(example = "Smart Phone")
    private String line;

    @Schema(example = "The phone you always desired ")
    private String slogan;

    @Schema(example = "[....]")
    private List<CategoryDTO> categoryDTOs;

    public String getIcon() {
        return icon;
    }

    public void setIcon(final String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getLine() {
        return line;
    }

    public void setLine(final String line) {
        this.line = line;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(final String slogan) {
        this.slogan = slogan;
    }

    public List<CategoryDTO> getCategoryDTOs() {
        return categoryDTOs;
    }

    public void setCategoryDTOs(final List<CategoryDTO> categoryDTOs) {
        this.categoryDTOs = categoryDTOs;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public ProductLineDTO() {
        this.setType(ProductLineDTO.DTO_NAME);
    }
}
