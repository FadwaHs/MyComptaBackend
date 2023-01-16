package com.codingart.mycompta.service.article;

import com.codingart.mycompta.model.article.TypeArticle;

import java.util.List;

public interface TypeArticleService {
    TypeArticle addTypeArticle(TypeArticle typeArticle);
    TypeArticle getTypeArticle(Long id);
    List<TypeArticle> getAllTypeArticle();
    TypeArticle updateTypeArticle(Long id, TypeArticle typeArticle);
    void deleteTypeArticle(Long id);
}
