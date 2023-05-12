package com.codingart.mycompta.controller.livraison;

import com.codingart.mycompta.model.livraison.Livraison;
import com.codingart.mycompta.service.livraison.LivraisonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livraisons")
@RequiredArgsConstructor
public class LivraisonController {
    
    private final LivraisonService livraisonService;

    @GetMapping("{id}")
    public ResponseEntity<Livraison> getLivraisonById(@PathVariable Long id){
        return new ResponseEntity<>(livraisonService.getLivraison(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Livraison>> getAllLivraison(){
        return new ResponseEntity<>(livraisonService.getAllLivraisons(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Livraison> createLivraison(@Valid @RequestBody Livraison livraison){
        return new ResponseEntity<>(livraisonService.addLivraison(livraison), HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Livraison> updateLivraison(@PathVariable Long id, @Valid @RequestBody Livraison livraison){
        return new ResponseEntity<>(livraisonService.updateLivraison(id,livraison), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLivraison(@PathVariable Long id){
        livraisonService.deleteLivraison(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
