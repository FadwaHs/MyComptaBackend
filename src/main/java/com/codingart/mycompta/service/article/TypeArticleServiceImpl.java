package com.codingart.mycompta.service.article;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.article.TypeArticle;
import com.codingart.mycompta.repository.article.TypeArticleRepository;
import com.codingart.mycompta.service.article.TypeArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeArticleServiceImpl implements TypeArticleService {

    private final TypeArticleRepository typeArticleRepository;
    private final String message = "TypeArticle not found for this id :: ";


    @Override
    public TypeArticle addTypeArticle(TypeArticle typeArticle) {
        return typeArticleRepository.save(typeArticle);

    }

    @Override
    public TypeArticle getTypeArticle(Long id) {
        return typeArticleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<TypeArticle> getAllTypeArticle() {
        return typeArticleRepository.findAll();
    }

    @Override
    public TypeArticle updateTypeArticle( Long id, TypeArticle typeArticle) {
        typeArticleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        typeArticle.setId(id);
        return typeArticleRepository.save(typeArticle);
    }

    @Override
    public void deleteTypeArticle(Long id) {
        typeArticleRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        typeArticleRepository.deleteById(id);
    }

}
