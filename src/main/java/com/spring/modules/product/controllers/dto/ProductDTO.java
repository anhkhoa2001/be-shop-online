package com.spring.modules.product.controllers.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.core.controller.dto.AItemDTO;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import com.spring.modules.category.controller.dtos.ProductLineDTO;
import com.spring.modules.category.model.CategoryModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn(name="cid", nullable=false)
    private CategoryDTO categoryDTO;

    public ProductDTO() {
        this.setType(ProductDTO.DTO_NAME);
    }

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

    public long getPriceDola() {
        return price/22;
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

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(final CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public ProductDTO(final String name, final String code, final long price,
                      final int quantityStock, final String image, final CategoryDTO categoryDTO) {
        this.setType(ProductDTO.DTO_NAME);
        this.setCode(code);
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this.image = image;
        this.categoryDTO = categoryDTO;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantityStock=" + quantityStock +
                ", image='" + image + '\'' +
                ", categoryDTO=" + categoryDTO +
                "} " + super.toString();
    }
}
