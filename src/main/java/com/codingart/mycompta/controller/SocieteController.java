package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.Societe;
import com.codingart.mycompta.service.SocieteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/societes")
@RequiredArgsConstructor
public class SocieteController {

    private final SocieteService societeService;

    @GetMapping("{id}")
    public ResponseEntity<Societe> getSocieteById(@PathVariable Long id){
        return new ResponseEntity<>(societeService.getSociete(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Societe>> getAllSociete(){
        return new ResponseEntity<>(societeService.getAllSociete(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Societe> createSociete(@Valid @RequestBody Societe societe){
        return new ResponseEntity<>(societeService.addSociete(societe), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Societe> updateSociete(@PathVariable Long id, @Valid @RequestBody Societe societe){
        return new ResponseEntity<>(societeService.updateSociete(id,societe), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSociete(@PathVariable Long id){
        societeService.deleteSociete(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
