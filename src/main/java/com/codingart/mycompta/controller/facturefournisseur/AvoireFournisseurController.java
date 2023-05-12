package com.codingart.mycompta.controller.facturefournisseur;


import com.codingart.mycompta.model.facture.FactureAvoir;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.service.facturefournisseur.AvoirFournisseurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturesfournisseur-avoir")
@RequiredArgsConstructor
public class AvoireFournisseurController {

    private  final AvoirFournisseurService avoirFournisseurService;

    @GetMapping("{id}")
    public ResponseEntity<AvoireFournisseur> getAvoireFournisseurrById(@PathVariable Long id){
        return new ResponseEntity<>(avoirFournisseurService.getAvoireFournisseur(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AvoireFournisseur>> getAllAvoireFournisseur(){
        return new ResponseEntity<>(avoirFournisseurService.getAllAvoireFournisseur(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvoireFournisseur> createAvoireFournisseur(@Valid @RequestBody AvoireFournisseur avoireFournisseur){
        return new ResponseEntity<>(avoirFournisseurService.addAvoireFournisseur(avoireFournisseur), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AvoireFournisseur> updateAvoireFournisseur(@PathVariable Long id, @Valid @RequestBody AvoireFournisseur avoireFournisseur){
        return new ResponseEntity<>(avoirFournisseurService.updateAvoireFournisseur(id,avoireFournisseur), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAvoireFournisseur(@PathVariable Long id){
        avoirFournisseurService.deleteAvoireFournisseur(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
