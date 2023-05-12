package com.codingart.mycompta.controller.facturefournisseur;


import com.codingart.mycompta.model.facturefournisseur.Paiement;
import com.codingart.mycompta.service.facturefournisseur.PaiementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final PaiementService paiementService;

    @GetMapping("{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long id){
        return new ResponseEntity<>(paiementService.getPaiement(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Paiement>> getAllPaiement(){
        return new ResponseEntity<>(paiementService.getAllPaiement(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paiement> createPaiement(@Valid @RequestBody Paiement paiement){
        return new ResponseEntity<>(paiementService.addPaiement(paiement), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long id, @Valid @RequestBody Paiement paiement){
        return new ResponseEntity<>(paiementService.updatePaiement(id,paiement), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePaiement(@PathVariable Long id){
        paiementService.deletePaiement(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
