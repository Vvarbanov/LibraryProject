package com.uni.library.model;

import com.uni.library.model.abstractModel.AbstractBook;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "newspapers")
public class Newspaper extends AbstractBook {

    public Newspaper() {}

    public Newspaper(Newspaper newspaper){
        this.setName(newspaper.getName());
        this.setDate(newspaper.getDate());
    }
}
