package com.uni.library.model;

import com.uni.library.model.abstractModel.AbstractBook;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book extends AbstractBook {

    @Column(name = "genre")
    private String genre;

    @Column(name = "author")
    private String author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.EAGER)
    private List<Chapter> chapters;

    public Book () {}

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

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
