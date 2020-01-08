package com.uni.library.model;

import com.uni.library.model.abstractModel.AbstractChapter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item extends AbstractChapter {

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private double price;

    public Item(Item item) {
        this.setManufacturer(item.getManufacturer());
        this.setPrice(item.getPrice());
        this.setTitle(item.getTitle());
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
}
