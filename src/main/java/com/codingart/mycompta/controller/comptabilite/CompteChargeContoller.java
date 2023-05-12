package com.codingart.mycompta.controller.comptabilite;

import com.codingart.mycompta.model.comptabilite.CompteCharge;
import com.codingart.mycompta.model.comptabilite.CompteTiers;
import com.codingart.mycompta.service.comptabilite.CompteChargeService;
import com.codingart.mycompta.service.comptabilite.CompteTiersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptecharges")
@RequiredArgsConstructor
public class CompteChargeContoller {

    private final CompteChargeService compteChargeService;

    @GetMapping("{id}")
    public ResponseEntity<CompteCharge> getCompteTiersById(@PathVariable Long id){
        return new ResponseEntity<>(compteChargeService.getCompteCharge(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CompteCharge>> getAllCompteCharge(){
        return new ResponseEntity<>(compteChargeService.getAllCompteCharge(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompteCharge> createCompteCharge(@Valid @RequestBody CompteCharge compteCharge){
        return new ResponseEntity<>(compteChargeService.addCompteCharge(compteCharge), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CompteCharge> updateCompteCharge(@PathVariable Long id, @Valid @RequestBody CompteCharge compteCharge){
        return new ResponseEntity<>(compteChargeService.updateCompteCharge(id,compteCharge), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompteCharge(@PathVariable Long id){
        compteChargeService.deleteCompteCharge(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
