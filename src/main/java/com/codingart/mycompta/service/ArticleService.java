package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Article;

import java.util.List;

public interface ArticleService {

    Article addArticle(Article article);
    Article getArticle(Long id);
    List<Article> getAllArticle();
    Article updateArticle(Long id, Article article);
    void deleteArticle(Long id);
}
