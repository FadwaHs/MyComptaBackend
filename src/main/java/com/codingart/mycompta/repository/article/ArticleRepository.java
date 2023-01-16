package com.codingart.mycompta.repository.article;

import com.codingart.mycompta.model.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}