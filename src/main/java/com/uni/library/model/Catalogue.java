package com.uni.library.model;

import com.uni.library.model.abstractModel.AbstractBook;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "catalogues")
public class Catalogue extends AbstractBook {

    public Catalogue() {}

    public Catalogue(Catalogue catalogue){
        this.setName(catalogue.getName());
        this.setDate(catalogue.getDate());
    }
}
