package com.codingart.mycompta.controller.article;

import com.codingart.mycompta.model.article.TypeArticle;
import com.codingart.mycompta.service.article.TypeArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeArticles")
@RequiredArgsConstructor
public class TypeArticleController {

    private final TypeArticleService typeArticleService;

    @GetMapping("{id}")
    public ResponseEntity<TypeArticle> getTypeArticleById(@PathVariable Long id){
        return new ResponseEntity<>(typeArticleService.getTypeArticle(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TypeArticle>> getAllTypeArticle(){
        return new ResponseEntity<>(typeArticleService.getAllTypeArticle(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeArticle> createTypeArticle(@Valid @RequestBody TypeArticle typeArticle){
        return new ResponseEntity<>(typeArticleService.addTypeArticle(typeArticle), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<TypeArticle> updateTypeArticle(@PathVariable Long id, @Valid @RequestBody TypeArticle typeArticle){
        return new ResponseEntity<>(typeArticleService.updateTypeArticle(id,typeArticle), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTypeArticle(@PathVariable Long id){
        typeArticleService.deleteTypeArticle(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
