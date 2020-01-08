package com.uni.library.model;

import com.uni.library.model.abstractModel.AbstractBook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends AbstractBook {

    @Column(name = "genre")
    private String genre;

    @Column(name = "author")
    private String author;

    public Book () {}

    public Book(Book book) {
        this.setGenre(book.getGenre());
        this.setAuthor(book.getAuthor());
        this.setName(book.getName());
        this.setDate(book.getDate());
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
