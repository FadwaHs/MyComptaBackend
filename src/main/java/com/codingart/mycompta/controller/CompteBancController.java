package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.CompteBanc;
import com.codingart.mycompta.service.CompteBancService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compteBancs")
@RequiredArgsConstructor
public class CompteBancController {

    private final CompteBancService compteBancService;

    @GetMapping("{id}")
    public ResponseEntity<CompteBanc> getCompteBancById(@PathVariable Long id){
        return new ResponseEntity<>(compteBancService.getCompteBanc(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CompteBanc>> getAllCompteBanc(){
        return new ResponseEntity<>(compteBancService.getAllCompteBanc(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompteBanc> createCompteBanc(@Valid @RequestBody CompteBanc compteBanc){
        return new ResponseEntity<>(compteBancService.addCompteBanc(compteBanc), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CompteBanc> updateCompteBanc(@PathVariable Long id, @Valid @RequestBody CompteBanc compteBanc){
        return new ResponseEntity<>(compteBancService.updateCompteBanc(id,compteBanc), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompteBanc(@PathVariable Long id){
        compteBancService.deleteCompteBanc(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
