package com.codingart.mycompta.service.article;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.article.TypeArticle;
import com.codingart.mycompta.repository.article.TypeArticleRepository;
import com.codingart.mycompta.service.article.TypeArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TypeArticleServiceImpl implements TypeArticleService {

    private final TypeArticleRepository typeArticleRepository;
    private final String message = "TypeArticle not found for this id :: ";


    @Override
    public void initTypesArticle() {
        ArrayList<TypeArticle> listTypeArticle = new ArrayList<>();
        listTypeArticle.add( TypeArticle.builder().id(1L).name_fr("Service").name_en("Service").build() );
        listTypeArticle.add( TypeArticle.builder().id(2L).name_fr("Produit").name_en("Product").build() );
        listTypeArticle.add( TypeArticle.builder().id(3L).name_fr("Jours").name_en("Days").build() );
        listTypeArticle.add( TypeArticle.builder().id(4L).name_fr("Heures").name_en("Hours").build() );
        listTypeArticle.add( TypeArticle.builder().id(5L).name_fr("Acompte").name_en("Down payment").build() );
        typeArticleRepository.saveAll(listTypeArticle);
    }

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
