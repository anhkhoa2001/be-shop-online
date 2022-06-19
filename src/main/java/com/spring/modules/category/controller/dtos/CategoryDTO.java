package com.spring.modules.category.controller.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.core.controller.dto.AItemDTO;
import com.spring.modules.product.controllers.dto.ProductDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Schema(title = CategoryDTO.DTO_NAME, description = "Data transfer object for " + CategoryDTO.DTO_NAME)
public class CategoryDTO extends AItemDTO {

    public static final String DTO_NAME = "CategoryDTO";

    @Schema(example = DTO_NAME, required = true)
    private String type;

    @Schema(example = "Iphone")
    private String line;

    @Schema(example = "image.png")
    private String logo;

    @Schema(example = "{...}")
    private ProductLineDTO productLineDTO;

    @Schema(example = "{...}")
    private ManufacturerDTO manufacturerDTO;

    @Schema(example = "")
    private String categoryCode;

    @Schema(example = "10")
    private int sizeProduct;

    public CategoryDTO() {
        this.setType(CategoryDTO.DTO_NAME);
    }

    public String getLine() {
        return line;
    }

    public void setLine(final String line) {
        this.line = line;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(final String logo) {
        this.logo = logo;
    }

    public ProductLineDTO getProductLineDTO() {
        return productLineDTO;
    }

    public void setProductLineDTO(final ProductLineDTO productLineDTO) {
        this.productLineDTO = productLineDTO;
    }

    public ManufacturerDTO getManufacturerDTO() {
        return manufacturerDTO;
    }

    public void setManufacturerDTO(final ManufacturerDTO manufacturerDTO) {
        this.manufacturerDTO = manufacturerDTO;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(final String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getSizeProduct() {
        return sizeProduct;
    }

    public void setSizeProduct(final int sizeProduct) {
        this.sizeProduct = sizeProduct;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "type='" + type + '\'' +
                ", line='" + line + '\'' +
                ", logo='" + logo + '\'' +
                ", productLineDTO=" + productLineDTO +
                ", manufacturerDTO=" + manufacturerDTO +
                ", categoryCode='" + categoryCode + '\'' +
                ", sizeProduct=" + sizeProduct +
                "} " + super.getId();
    }
}
