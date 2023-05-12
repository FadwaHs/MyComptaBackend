package com.codingart.mycompta.controller.fournisseur;


import com.codingart.mycompta.model.bon.BonLivraison;
import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.facturefournisseur.AvoireFournisseur;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.model.fournisseur.Fournisseur;
import com.codingart.mycompta.model.opportunite.Opportunite;
import com.codingart.mycompta.service.fournisseur.FournisseurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
@RequiredArgsConstructor
public class FournisseurController {

    private final FournisseurService fournisseurService;

    @GetMapping("{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Long id){
        return new ResponseEntity<>(fournisseurService.getFournisseur(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Fournisseur>> getAllFournisseur(){
        return new ResponseEntity<>(fournisseurService.getAllFournisseur(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fournisseur> createFournisseur(@Valid @RequestBody Fournisseur fournisseur){
        return new ResponseEntity<>(fournisseurService.addFournisseur(fournisseur), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable Long id, @Valid @RequestBody Fournisseur fournisseur){
        return new ResponseEntity<>(fournisseurService.updateFournisseur(id,fournisseur), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFournisseur(@PathVariable Long id){
        fournisseurService.deleteFournisseur(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("simple/{id}")
    public ResponseEntity<List<SimpleFournisseur>> getAllSimpleForFournisseur(@PathVariable Long id ){
        return new ResponseEntity<>(fournisseurService.getAllSimple(id), HttpStatus.OK);
    }

    @GetMapping("avoir/{id}")
    public ResponseEntity<List<AvoireFournisseur>> getAllAvoirForFournisseur(@PathVariable Long id ){
        return new ResponseEntity<>(fournisseurService.getAllAvoire(id), HttpStatus.OK);
    }


    @GetMapping("bc/{id}")
    public ResponseEntity<List<BonsCommande>> getAllBonsCommandeForFournisseur(@PathVariable Long id ){
        return new ResponseEntity<>(fournisseurService.getAllBonsCommande(id), HttpStatus.OK);
    }

    @GetMapping("bl/{id}")
    public ResponseEntity<List<BonLivraison>> getAllBonLivraisonForFournisseur(@PathVariable Long id ){
        return new ResponseEntity<>(fournisseurService.getAllBonLivraison(id), HttpStatus.OK);
    }

}
