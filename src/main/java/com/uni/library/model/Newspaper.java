package com.uni.library.model;

import com.uni.library.model.abstractModel.AbstractBook;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "newspapers")
public class Newspaper extends AbstractBook {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newspaper", fetch = FetchType.EAGER)
    private List<Article> articles;

    public Newspaper() {}

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
