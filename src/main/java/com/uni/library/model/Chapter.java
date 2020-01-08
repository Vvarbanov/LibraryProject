package com.uni.library.model;

import com.uni.library.model.abstractModel.AbstractChapter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chapters")
public class Chapter extends AbstractChapter {

    @Column(name = "content")
    private String content;

    public Chapter () {}

    public Chapter(Chapter chapter) {
        this.setContent(chapter.getContent());
        this.setTitle(chapter.getTitle());
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
