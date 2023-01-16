package com.codingart.mycompta.service.impl.article;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.article.Article;
import com.codingart.mycompta.repository.article.ArticleRepository;
import com.codingart.mycompta.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final String message = "Article not found for this id :: ";


    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);

    }

    @Override
    public Article getArticle(Long id) {
        return articleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Article updateArticle( Long id, Article article) {
        articleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        article.setId(id);
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        articleRepository.deleteById(id);
    }

}
