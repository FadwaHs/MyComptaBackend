package com.codingart.mycompta.controller.facturefournisseur;


import com.codingart.mycompta.model.facture.FactureSimple;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.service.facturefournisseur.SimpleFournisseurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturesfournisseur-simple")
@RequiredArgsConstructor
public class SimpleFournisseurController {

    private  final SimpleFournisseurService simpleFournisseurService;

    @GetMapping("{id}")
    public ResponseEntity<SimpleFournisseur> getSimpleFournisseurById(@PathVariable Long id){
        return new ResponseEntity<>(simpleFournisseurService.getSimpleFournisseur(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SimpleFournisseur>> getAllSimpleFournisseur(){
        return new ResponseEntity<>(simpleFournisseurService.getAllSimpleFournisseur(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleFournisseur> createSimpleFournisseur(@Valid @RequestBody SimpleFournisseur simpleFournisseur){
        return new ResponseEntity<>(simpleFournisseurService.addSimpleFournisseur(simpleFournisseur), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<SimpleFournisseur> updateSimpleFournisseur(@PathVariable Long id, @Valid @RequestBody SimpleFournisseur simpleFournisseur){
        return new ResponseEntity<>(simpleFournisseurService.updateSimpleFournisseur(id,simpleFournisseur), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSimpleFournisseur(@PathVariable Long id){
        simpleFournisseurService.deleteSimpleFournisseur(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
