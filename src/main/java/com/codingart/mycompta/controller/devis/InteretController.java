package com.codingart.mycompta.controller.devis;

import com.codingart.mycompta.model.devis.Interet;
import com.codingart.mycompta.service.devis.InteretService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interets")
@RequiredArgsConstructor
public class InteretController {

    private final InteretService interetService;

    @PostConstruct
    public void defaultConditionReglement(){
        interetService.initInterets();
    }

    @GetMapping("{id}")
    public ResponseEntity<Interet> getInteretById(@PathVariable Long id){
        return new ResponseEntity<>(interetService.getInteret(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Interet>> getAllInteret(){
        return new ResponseEntity<>(interetService.getAllInteret(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Interet> createInteret(@Valid @RequestBody Interet interet){
        return new ResponseEntity<>(interetService.addInteret(interet), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Interet> updateInteret(@PathVariable Long id, @Valid @RequestBody Interet interet){
        return new ResponseEntity<>(interetService.updateInteret(id,interet), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInteret(@PathVariable Long id){
        interetService.deleteInteret(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
