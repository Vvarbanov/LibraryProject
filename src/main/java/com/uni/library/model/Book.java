package com.uni.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends AbstractBook{

    @Column(name = "genre")
    private String genre;

    @Column(name = "author")
    private String author;

    public Book () {}

    public Book(Book book) {
        this.genre = book.getGenre();
        this.author = book.getAuthor();
        this.name = book.getName();
        this.date = book.getDate();
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
