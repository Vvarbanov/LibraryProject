package com.uni.library.service;

import com.uni.library.model.Article;
import com.uni.library.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles(){
        return (List<Article>) articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        if(articleRepository.findById(id).isPresent())
            return articleRepository.findById(id).get();
        return null;
    }

    public void deleteArticleById(Long id) {
        articleRepository.deleteById(id);
    }

    public void insertArticle(Article article) {
        articleRepository.save(article);
    }

    public void updateArticle(Long id, Article updateArticle) {
        if(articleRepository.findById(id).isPresent()){
            updateArticle.setId(id);
            articleRepository.save(updateArticle);
        }
    }
}
