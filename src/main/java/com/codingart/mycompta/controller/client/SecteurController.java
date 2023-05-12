package com.codingart.mycompta.controller.client;

import com.codingart.mycompta.model.client.Secteur;
import com.codingart.mycompta.service.client.SecteurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secteurs")
@RequiredArgsConstructor
public class SecteurController {
    private final SecteurService secteurService;

    @GetMapping("{id}")
    public ResponseEntity<Secteur> getSecteurById(@PathVariable Long id){
        return new ResponseEntity<>(secteurService.getSecteur(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Secteur>> getAllSecteur(){
        return new ResponseEntity<>(secteurService.getAllSecteur(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Secteur> createSecteur(@Valid @RequestBody Secteur secteur){
        return new ResponseEntity<>(secteurService.addSecteur(secteur), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Secteur> updateSecteur(@PathVariable Long id, @Valid @RequestBody Secteur secteur){
        return new ResponseEntity<>(secteurService.updateSecteur(id,secteur), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSecteur(@PathVariable Long id){
        secteurService.deleteSecteur(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
