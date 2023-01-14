package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.Membre;
import com.codingart.mycompta.service.MembreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membres")
@RequiredArgsConstructor
public class MembreController {

    private final MembreService membreService;

    @GetMapping("{id}")
    public ResponseEntity<Membre> getMembreById(@PathVariable Long id){
        return new ResponseEntity<>(membreService.getMembre(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Membre>> getAllMembre(){
        return new ResponseEntity<>(membreService.getAllMembre(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Membre> createMembre(@Valid @RequestBody Membre membre){
        return new ResponseEntity<>(membreService.addMembre(membre), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Membre> updateMembre(@PathVariable Long id, @Valid @RequestBody Membre membre){
        return new ResponseEntity<>(membreService.updateMembre(id,membre), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMembre(@PathVariable Long id){
        membreService.deleteMembre(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
