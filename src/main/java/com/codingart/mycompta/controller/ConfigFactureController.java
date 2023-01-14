package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.ConfigFacture;
import com.codingart.mycompta.service.ConfigFactureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configFactures")
@RequiredArgsConstructor
public class ConfigFactureController {

    private final ConfigFactureService configFactureService;

    @GetMapping("{id}")
    public ResponseEntity<ConfigFacture> getConfigFactureById(@PathVariable Long id){
        return new ResponseEntity<>(configFactureService.getConfigFacture(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ConfigFacture>> getAllConfigFacture(){
        return new ResponseEntity<>(configFactureService.getAllConfigFacture(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConfigFacture> createConfigFacture(@Valid @RequestBody ConfigFacture configFacture){
        return new ResponseEntity<>(configFactureService.addConfigFacture(configFacture), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ConfigFacture> updateConfigFacture(@PathVariable Long id, @Valid @RequestBody ConfigFacture configFacture){
        return new ResponseEntity<>(configFactureService.updateConfigFacture(id,configFacture), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteConfigFacture(@PathVariable Long id){
        configFactureService.deleteConfigFacture(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
