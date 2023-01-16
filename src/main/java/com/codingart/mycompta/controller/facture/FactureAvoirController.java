package com.codingart.mycompta.controller.facture;

import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.service.facture.FactureAvoirService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factureAvoirs")
@RequiredArgsConstructor
public class FactureAvoirController {

    private final FactureAvoirService factureAvoirService;

    @GetMapping("{id}")
    public ResponseEntity<FactureAvoir> getFactureAvoirById(@PathVariable Long id){
        return new ResponseEntity<>(factureAvoirService.getFactureAvoir(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FactureAvoir>> getAllFactureAvoir(){
        return new ResponseEntity<>(factureAvoirService.getAllFactureAvoir(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FactureAvoir> createFactureAvoir(@Valid @RequestBody FactureAvoir factureAvoir){
        return new ResponseEntity<>(factureAvoirService.addFactureAvoir(factureAvoir), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<FactureAvoir> updateFactureAvoir(@PathVariable Long id, @Valid @RequestBody FactureAvoir factureAvoir){
        return new ResponseEntity<>(factureAvoirService.updateFactureAvoir(id,factureAvoir), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFactureAvoir(@PathVariable Long id){
        factureAvoirService.deleteFactureAvoir(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
