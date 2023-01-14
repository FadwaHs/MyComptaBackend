package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.Article;
import com.codingart.mycompta.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id){
        return new ResponseEntity<>(articleService.getArticle(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticle(){
        return new ResponseEntity<>(articleService.getAllArticle(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@Valid @RequestBody Article article){
        return new ResponseEntity<>(articleService.addArticle(article), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @Valid @RequestBody Article article){
        return new ResponseEntity<>(articleService.updateArticle(id,article), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
