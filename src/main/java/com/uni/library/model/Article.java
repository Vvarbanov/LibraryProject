package com.uni.library.model;

import com.uni.library.model.abstractModel.AbstractChapter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article extends AbstractChapter {

    @Column(name = "content")
    private String content;

    public Article () {}

    public Article(Article article) {
        this.setContent(article.getContent());
        this.setTitle(article.getTitle());
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
