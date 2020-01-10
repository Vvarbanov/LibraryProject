package com.uni.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uni.library.model.abstractModel.AbstractChapter;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item extends AbstractChapter {

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "catalogue_id")
    private Catalogue catalogue;

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

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }
}
