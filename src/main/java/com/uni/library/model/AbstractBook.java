package com.uni.library.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class AbstractBook {

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    String name;

    @Column(name = "date")
    LocalDate date;

    String getName() {
        return name;
    }

    LocalDate getDate() {
        return date;
    }
}
