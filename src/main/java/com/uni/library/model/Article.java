package com.uni.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uni.library.model.abstractModel.AbstractChapter;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article extends AbstractChapter {

    @Column(name = "content")
    private String content;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "newspaper_id")
    private Newspaper newspaper;

    public Article () {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Newspaper getNewspaper() {
        return newspaper;
    }

    public void setNewspaper(Newspaper newspaper) {
        this.newspaper = newspaper;
    }
}
