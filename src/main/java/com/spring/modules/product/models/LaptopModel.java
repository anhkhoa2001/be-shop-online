package com.spring.modules.product.models;

import javax.persistence.*;

@Entity
@Table(name = "laptop")
public class LaptopModel extends ProductModel {

    public static final String MODEL_NAME = "Laptop";

    @Basic
    private String display;

    @Basic
    private String memory;

    @Basic
    private String cpu;

    @Basic
    private String ram;

    @Basic
    private String card;

    @Basic
    private float weight;

    @Basic
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
}
