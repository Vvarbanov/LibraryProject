package com.uni.library.dto;

import com.uni.library.model.Chapter;

import java.time.LocalDate;
import java.util.List;

public class BookDTO {

    private String name;
    private LocalDate date;
    private String genre;
    private String author;

    public BookDTO(String name, LocalDate date, String genre, String author) {
        this.name = name;
        this.date = date;
        this.genre = genre;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
