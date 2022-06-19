package com.spring.modules.product.controllers.dto;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.spring.modules.category.controller.dtos.CategoryDTO;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Schema(title = PhoneTabDTO.DTO_NAME, description = "Data transfer object for " + PhoneTabDTO.DTO_NAME)
public class PhoneTabDTO extends ProductDTO {

    public static final String DTO_NAME = "PhoneTabDTO";

    @Schema(example = "10.9\", IPS LCD")
    private String display;

    @Schema(example = "8 MP")
    private String frontCamera;

    @Schema(example = "8 MP")
    private String backCamera;

    @Schema(example = "Apple A13 Bionic")
    private String chip;

    @Schema(example = " 128 GB")
    private String memory;

    @Schema(example = "6 GB")
    private String ram;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(final String display) {
        this.display = display;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(final String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public String getBackCamera() {
        return backCamera;
    }

    public void setBackCamera(final String backCamera) {
        this.backCamera = backCamera;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(final String chip) {
        this.chip = chip;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(final String memory) {
        this.memory = memory;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(final String ram) {
        this.ram = ram;
    }

    public PhoneTabDTO() {
        super.setType(PhoneTabDTO.DTO_NAME);
    }

    public PhoneTabDTO(final String code, final String name, final long price, final int quantity, final String image,
                       final String display, final String frontCamera, final String backCamera, final String chip, final String memory, final String ram) {
        super.setType(PhoneTabDTO.DTO_NAME);
        super.setImage(image);
        super.setName(name);
        super.setPrice(price);
        super.setCode(code);
        super.setQuantityStock(quantity);
        this.display = display;
        this.frontCamera = frontCamera;
        this.backCamera = backCamera;
        this.chip = chip;
        this.memory = memory;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "PhoneTabDTO{" +
                "display='" + display + '\'' +
                ", frontCamera='" + frontCamera + '\'' +
                ", backCamera='" + backCamera + '\'' +
                ", chip='" + chip + '\'' +
                ", memory='" + memory + '\'' +
                ", ram='" + ram + '\'' +
                "} " + super.toString();
    }
}
