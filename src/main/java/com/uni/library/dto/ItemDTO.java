package com.uni.library.dto;

public class ItemDTO {

    private String title;
    private String manufacturer;
    private double price;
    private Long catalogue_id;

    public ItemDTO(String title, String manufacturer, double price, Long catalogue_id) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.price = price;
        this.catalogue_id = catalogue_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCatalogue_id() {
        return catalogue_id;
    }

    public void setCatalogue_id(Long catalogue_id) {
        this.catalogue_id = catalogue_id;
    }
}
