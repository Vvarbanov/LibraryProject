package com.uni.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uni.library.model.abstractModel.AbstractChapter;

import javax.persistence.*;

@Entity
@Table(name = "chapters")
public class Chapter extends AbstractChapter {

    @Lob
    @Column(name = "content")
    private String content;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Chapter () {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
