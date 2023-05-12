package com.codingart.mycompta.controller.bon;

import com.codingart.mycompta.model.bon.BonsCommande;
import com.codingart.mycompta.model.facturefournisseur.SimpleFournisseur;
import com.codingart.mycompta.service.bon.BonCommandeService;
import com.codingart.mycompta.service.facturefournisseur.SimpleFournisseurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bonCommande")
@RequiredArgsConstructor
public class BonCommandeController {

    private  final BonCommandeService bonCommandeService;

    @GetMapping("{id}")
    public ResponseEntity<BonsCommande> getBonsCommandeById(@PathVariable Long id){
        return new ResponseEntity<>(bonCommandeService.getBonsCommande(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BonsCommande>> getAllBonsCommandes(){
        return new ResponseEntity<>(bonCommandeService.getAllBonsCommande(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BonsCommande> createBonsCommande(@Valid @RequestBody BonsCommande bonsCommande){
        return new ResponseEntity<>(bonCommandeService.addBonsCommande(bonsCommande), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<BonsCommande> updateBonsCommande(@PathVariable Long id, @Valid @RequestBody BonsCommande bonsCommande){
        return new ResponseEntity<>(bonCommandeService.updateBonsCommande(id,bonsCommande), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBonsCommande(@PathVariable Long id){
        bonCommandeService.deleteBonsCommande(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
