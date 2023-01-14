package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}