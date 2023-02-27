package com.codingart.mycompta.controller.client;

import com.codingart.mycompta.model.client.Client;
import com.codingart.mycompta.model.client.Societe;
import com.codingart.mycompta.repository.client.SocieteRepository;
import com.codingart.mycompta.service.client.SocieteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/societes")
@RequiredArgsConstructor
public class SocieteController {
    private final SocieteService societeService;
    private final SocieteRepository societeRepository;
    
    

    @GetMapping("{id}")
    public ResponseEntity<Societe> getSocieteById(@PathVariable Long id){
        return new ResponseEntity<>(societeService.getSociete(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Societe>> getAllSociete(){
        return new ResponseEntity<>(societeService.getAllSociete(), HttpStatus.OK);
    }
    @GetMapping("pagination")
    public ResponseEntity<Map<String, Object>> getListSocietes(
            @RequestParam(required = false) String data,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return new ResponseEntity<>(societeService.getListSociete(data,page,size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Societe> createSociete(@Valid @RequestBody Societe societe){
        return new ResponseEntity<>(societeService.addSociete(societe), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Societe> updateSociete(@PathVariable Long id, @Valid @RequestBody Societe societe){
        return new ResponseEntity<>(societeService.updateSociete(id,societe), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity< String> deleteSociete(@PathVariable Long id){
        societeService.deleteSociete(id);
        return new ResponseEntity<>( "Deleted" ,HttpStatus.OK);
    }

    @GetMapping("recipient")
    public ResponseEntity<List<Societe>> getAllbyIdAndFirstNameAndLastName(){
        return new ResponseEntity<>(societeService.getAllByIdAndName(), HttpStatus.OK);
    }
}
