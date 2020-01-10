package com.uni.library.service;

import com.uni.library.dto.ArticleDTO;
import com.uni.library.model.Article;
import com.uni.library.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final NewspaperService newspaperService;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, NewspaperService newspaperService) {
        this.articleRepository = articleRepository;
        this.newspaperService = newspaperService;
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

    @Transactional
    public Long insertArticle(ArticleDTO articleDTO) {
        Long id = null;

        if (articleDTO != null){
            Article newArticle = new Article();

            newArticle.setTitle(articleDTO.getTitle());
            newArticle.setContent(articleDTO.getContent());
            newArticle.setNewspaper(newspaperService.getNewspaperById(articleDTO.getNewspaper_id()));

            id = articleRepository.save(newArticle).getId();
        }
        return id;
    }

    @Transactional
    public Long updateArticle(Long id, ArticleDTO updateArticle) {
        if(articleRepository.findById(id).isPresent() && updateArticle != null){
            Article newArticle = new Article();

            newArticle.setId(id);
            newArticle.setTitle(updateArticle.getTitle());
            newArticle.setContent(updateArticle.getContent());
            newArticle.setNewspaper(newspaperService.getNewspaperById(updateArticle.getNewspaper_id()));

            return articleRepository.save(newArticle).getId();
        }
        return null;
    }
}
