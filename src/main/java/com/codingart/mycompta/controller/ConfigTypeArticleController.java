package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.ConfigTypeArticle;
import com.codingart.mycompta.service.ConfigTypeArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configTypeArticles")
@RequiredArgsConstructor
public class ConfigTypeArticleController {

    private final ConfigTypeArticleService configTypeArticleService;

    @GetMapping("{id}")
    public ResponseEntity<ConfigTypeArticle> getConfigTypeArticleById(@PathVariable Long id){
        return new ResponseEntity<>(configTypeArticleService.getConfigTypeArticle(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ConfigTypeArticle>> getAllConfigTypeArticle(){
        return new ResponseEntity<>(configTypeArticleService.getAllConfigTypeArticle(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConfigTypeArticle> createConfigTypeArticle(@Valid @RequestBody ConfigTypeArticle configTypeArticle){
        return new ResponseEntity<>(configTypeArticleService.addConfigTypeArticle(configTypeArticle), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ConfigTypeArticle> updateConfigTypeArticle(@PathVariable Long id, @Valid @RequestBody ConfigTypeArticle configTypeArticle){
        return new ResponseEntity<>(configTypeArticleService.updateConfigTypeArticle(id,configTypeArticle), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteConfigTypeArticle(@PathVariable Long id){
        configTypeArticleService.deleteConfigTypeArticle(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
