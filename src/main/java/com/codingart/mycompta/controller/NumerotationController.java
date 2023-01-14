package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.Numerotation;
import com.codingart.mycompta.service.NumerotationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/numerotations")
@RequiredArgsConstructor
public class NumerotationController {

    private final NumerotationService numerotationService;

    @GetMapping("{id}")
    public ResponseEntity<Numerotation> getNumerotationById(@PathVariable Long id){
        return new ResponseEntity<>(numerotationService.getNumerotation(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Numerotation>> getAllNumerotation(){
        return new ResponseEntity<>(numerotationService.getAllNumerotation(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Numerotation> createNumerotation(@Valid @RequestBody Numerotation numerotation){
        return new ResponseEntity<>(numerotationService.addNumerotation(numerotation), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Numerotation> updateNumerotation(@PathVariable Long id, @Valid @RequestBody Numerotation numerotation){
        return new ResponseEntity<>(numerotationService.updateNumerotation(id,numerotation), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNumerotation(@PathVariable Long id){
        numerotationService.deleteNumerotation(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
