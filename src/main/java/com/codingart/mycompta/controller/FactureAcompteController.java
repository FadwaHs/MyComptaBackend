package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.FactureAcompte;
import com.codingart.mycompta.service.FactureAcompteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factureAcomptes")
@RequiredArgsConstructor
public class FactureAcompteController {

    private final FactureAcompteService factureAcompteService;

    @GetMapping("{id}")
    public ResponseEntity<FactureAcompte> getFactureAcompteById(@PathVariable Long id){
        return new ResponseEntity<>(factureAcompteService.getFactureAcompte(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FactureAcompte>> getAllFactureAcompte(){
        return new ResponseEntity<>(factureAcompteService.getAllFactureAcompte(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FactureAcompte> createFactureAcompte(@Valid @RequestBody FactureAcompte factureAcompte){
        return new ResponseEntity<>(factureAcompteService.addFactureAcompte(factureAcompte), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<FactureAcompte> updateFactureAcompte(@PathVariable Long id, @Valid @RequestBody FactureAcompte factureAcompte){
        return new ResponseEntity<>(factureAcompteService.updateFactureAcompte(id,factureAcompte), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFactureAcompte(@PathVariable Long id){
        factureAcompteService.deleteFactureAcompte(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
