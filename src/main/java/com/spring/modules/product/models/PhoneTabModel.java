package com.spring.modules.product.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phonetab")
public class PhoneTabModel extends ProductModel{

    public static final String MODEL_NAME = "PhoneTab";

    @Basic
    private String display;

    @Basic
    private String frontCamera;

    @Basic
    private String backCamera;

    @Basic
    private String chip;

    @Basic
    private String memory;

    @Basic
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
}
