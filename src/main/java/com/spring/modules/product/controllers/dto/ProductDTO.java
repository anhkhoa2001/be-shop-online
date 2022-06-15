package com.spring.modules.product.controllers.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.core.controller.dto.AItemDTO;
import com.spring.modules.category.model.CategoryModel;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Schema(title = ProductDTO.DTO_NAME, description = "Data transfer object for " + ProductDTO.DTO_NAME)
public class ProductDTO extends AItemDTO {

    public static final String DTO_NAME = "ProductDTO";

    @Schema(example = DTO_NAME, required = true)
    private String type;

    @Schema(example = "Iphone 13 Promax", required = true)
    private String name;

    @Schema(example = "1000", required = true)
    private long price;

    @Schema(example = "1", required = true)
    private int quantityStock;

    @Schema(example = "/image/image.png", required = true)
    private String image;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(final long price) {
        this.price = price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(final int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }
}
