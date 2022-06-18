package com.spring.modules.checkout.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.core.controller.dto.AItemDTO;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Schema(title = OrderProductDTO.DTO_NAME, description = "Data transfer object for " + OrderProductDTO.DTO_NAME)
public class OrderProductDTO extends AItemDTO {

    public static final String DTO_NAME = "OrderProductDTO";

    @Schema(example = DTO_NAME)
    private String type;

    @Schema(example = "5")
    private int quantity;

    @Schema(example = "5")
    private int total;

    @Schema(example = "{...}")
    private CategoryDTO categoryDTO;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(final int total) {
        this.total = total;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(final CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public OrderProductDTO() {
        this.setType(OrderDTO.DTO_NAME);
    }
}
