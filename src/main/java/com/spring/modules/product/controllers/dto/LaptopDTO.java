package com.spring.modules.product.controllers.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@Schema(title = LaptopDTO.DTO_NAME, description = "Data transfer object for " + LaptopDTO.DTO_NAME)
public class LaptopDTO extends ProductDTO {

    public static final String DTO_NAME = "LaptopDTO";

    @Schema(example = "14.0\", 1920 x 1080 Pixel, IPS, 60 Hz, 400 nits, Anti-glare LED-backlit")
    private String display;

    @Schema(example = "SSD 512 GB")
    private String memory;

    @Schema(example = "Intel Core i7-1165G7")
    private String cpu;

    @Schema(example = "16 GB, LPDDR4X, 4266 MHz")
    private String ram;

    @Schema(example = "Intel Iris Xe Graphics")
    private String card;

    @Schema(example = "1.17")
    private float weight;

    @Schema(example = "319 x 208 x 13.9")
    private String size;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(final String display) {
        this.display = display;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(final String memory) {
        this.memory = memory;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(final String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(final String ram) {
        this.ram = ram;
    }

    public String getCard() {
        return card;
    }

    public void setCard(final String card) {
        this.card = card;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(final float weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(final String size) {
        this.size = size;
    }

    public LaptopDTO() {
        super.setType(LaptopDTO.DTO_NAME);
    }
}
