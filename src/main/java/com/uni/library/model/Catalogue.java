package com.uni.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uni.library.model.abstractModel.AbstractBook;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "catalogues")
public class Catalogue extends AbstractBook {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "catalogue")
    private List<Item> items;

    public Catalogue() {}

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
