package com.uni.library.controller;

import com.uni.library.dto.ArticleDTO;
import com.uni.library.model.Article;
import com.uni.library.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/articles")
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public ResponseEntity insertArticle(@NonNull @Valid @RequestBody ArticleDTO articleDTO) {
        return ResponseEntity.ok(articleService.insertArticle(articleDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateArticleById(@PathVariable Long id, @Valid @NonNull @RequestBody ArticleDTO updateArticle) {
        return ResponseEntity.ok(articleService.updateArticle(id, updateArticle));
    }

    @DeleteMapping("{id}")
    public void deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
    }
}
